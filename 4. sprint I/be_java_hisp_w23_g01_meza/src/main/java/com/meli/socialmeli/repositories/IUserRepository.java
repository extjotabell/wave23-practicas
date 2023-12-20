package com.meli.socialmeli.repositories;

import com.meli.socialmeli.entities.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
    User finById(int id);
    List<User> getUserFollowed(User user);

    void removeUser(int userId);
}
