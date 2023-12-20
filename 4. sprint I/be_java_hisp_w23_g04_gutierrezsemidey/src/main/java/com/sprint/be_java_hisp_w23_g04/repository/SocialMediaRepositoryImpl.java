package com.sprint.be_java_hisp_w23_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.DBUserDTO;
import com.sprint.be_java_hisp_w23_g04.entity.Post;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import com.sprint.be_java_hisp_w23_g04.utils.UserMapper;
import com.sprint.be_java_hisp_w23_g04.utils.Verifications;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.spi.ToolProvider.findFirst;

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
        findUser(userId).getFollowed().removeIf(user1 -> user1.getId()==unfollowedUserId);
        findUser(unfollowedUserId).getFollowers().removeIf(user1 -> user1.getId()==userId);
    }

    public Post findPost(int postId, int userId){
        User user = this.findUser(userId);
        if(user == null){
            return null;
        }
      return user.getPosts().stream().filter(post -> post.getId() == postId).findFirst().orElse(null);
    };

    public void deletePost(int postId, int userId){
        findUser(userId).getPosts().removeIf(post -> post.getId()==postId);
    }
}
