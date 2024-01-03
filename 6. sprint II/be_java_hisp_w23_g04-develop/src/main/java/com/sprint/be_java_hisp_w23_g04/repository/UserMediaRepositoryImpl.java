package com.sprint.be_java_hisp_w23_g04.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class UserMediaRepositoryImpl implements IUserMediaRepository {
    private List<User> users = new ArrayList<>();

    public UserMediaRepositoryImpl() {
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

        TypeReference<List<User>> typeRef = new TypeReference<>() {
        };
        List<User> users = null;
        try {
            users = mapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    @Override
    public User findUser(Integer userId) {
        return this.users.stream().filter(u -> Objects.equals(u.getId(), userId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void unfollowUser(int userId, int unfollowedUserId) {
        findUser(userId)
                .getFollowedId()
                .removeIf(actualUserId ->
                        actualUserId == unfollowedUserId);

        findUser(unfollowedUserId)
                .getFollowersId()
                .removeIf(actualUserId ->
                        actualUserId == userId);
    }

    @Override
    public List<User> getByIds(List<Integer> listIds) {
        return users.stream().filter(
                        p -> listIds.contains(p.getId())).
                collect(Collectors.toCollection(ArrayList::new));

    }

}
