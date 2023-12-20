package com.sprint.be_java_hisp_w23_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.DBUserDTO;
import com.sprint.be_java_hisp_w23_g04.entity.PostPromo;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.utils.UserMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SocialMediaRepositoryImpl implements ISocialMediaRepository {
    private List<User> users = new ArrayList<>();

    public SocialMediaRepositoryImpl() {
        this.users = loadDataBase();
    }

    private List<User> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        TypeReference<List<DBUserDTO>> typeRef = new TypeReference<>() {
        };
        List<DBUserDTO> usersDto = null;
        try {
            usersDto = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usersDto != null ? usersDto.stream().map(UserMapper::mapUser).collect(Collectors.toList()) : Collections.emptyList();
    }

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public User findUser(Integer userId) {
        return this.users.stream().filter(u -> Objects.equals(u.getId(), userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public int getNextPostId(User user) {
        return this.users.stream()
                .filter(u -> Objects.equals(user, u))
                .findFirst()
                .get()
                .getPosts()
                .size() + 1;
    }

    @Override
    public void savePost(User user) {
        users.set(users.indexOf(user), user);
    }

    public void unfollowUser(int userId, int unfollowedUserId) {
        List<User> newFollowed = findUser(userId).getFollowed().stream().filter(user -> user.getId() != unfollowedUserId).toList();
        List<User> newFollowers = findUser(unfollowedUserId).getFollowers().stream().filter(user -> user.getId() != userId).toList();

        User user = findUser(userId);
        User unfollowedUser = findUser(unfollowedUserId);

        unfollowedUser.setFollowers(newFollowers);
        user.setFollowed(newFollowed);

        users.set(users.indexOf(findUser(userId)), user);
        users.set(users.indexOf(findUser(unfollowedUserId)), unfollowedUser);
    }

    @Override
    public List<User> findUsersWithPostPromo(String productName) {
        List<User> sellers = this.getSellers();

        return sellers.stream()
                .filter(user -> !user.getPosts().isEmpty())
                .filter(user -> user.getPosts().stream()
                        .anyMatch(post -> post instanceof PostPromo
                                && post.getProduct().getName().toLowerCase().contains(productName.toLowerCase())))
                .toList();
    }

    private List<User> getSellers() {
        return this.users.stream().filter(u -> !u.getPosts().isEmpty()).toList();
    }
}
