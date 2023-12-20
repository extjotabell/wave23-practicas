package com.meli.socialmeli.repositories.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.meli.socialmeli.entities.User;
import com.meli.socialmeli.exceptions.custom.DataSourceException;
import com.meli.socialmeli.repositories.IUserRepository;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Repository
public class UserRepositoryImpl implements IUserRepository {

    private List<User> users;
    public UserRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User finById(int id) {
        return users.stream().filter( u -> u.getUser_id() == id ).findFirst().orElse(null);
    }

    @Override
    public List<User> getUserFollowed(User user) {
        return user.getFollowed();
    }

    @Override
    public void removeUser(int userId) {
        Predicate<User> equalityById = u -> u.getUser_id().equals(userId);
        this.findAll().removeIf(equalityById);
        this.findAll().forEach(u -> {
            u.getFollowers().removeIf(equalityById);
            u.getFollowed().removeIf(equalityById);
        });
    }

    private void loadDataBase() {
        users = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File file= ResourceUtils.getFile("classpath:static/users-2.json");
            users = objectMapper.readValue(file,new TypeReference<List<User>>(){});

        } catch (IOException e) {
            throw new DataSourceException("There is an internal problem with the connection to the data source.");
        }
    }
}
