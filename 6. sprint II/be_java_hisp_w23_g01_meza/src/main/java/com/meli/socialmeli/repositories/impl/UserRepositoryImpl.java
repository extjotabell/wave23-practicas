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

    private void loadDataBase() {
        users = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

            File file= ResourceUtils.getFile("classpath:static/users-2.json");
            users = objectMapper.readValue(file,new TypeReference<List<User>>(){});

        } catch (IOException e) {
            throw new DataSourceException("Ocurrió un problema interno con la conexión hacia la base de datos.");
        }
    }
}
