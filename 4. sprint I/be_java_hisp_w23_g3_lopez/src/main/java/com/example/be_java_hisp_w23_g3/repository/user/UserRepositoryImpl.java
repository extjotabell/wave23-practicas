package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public Optional<User> read(Long userId) {
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst();
    }

    @Override
    public User create(User entity) {
        users.add(entity);
        return entity;
    }

    @Override
    public List<User> createAll(List<User> entities) {
        users.addAll(entities);
        return entities;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public Long getNextId() {
        return users.stream()
            .mapToLong(User::getId)
            .max()
            .orElse(0) + 1;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst();
    }

    @Override
    public Optional<Seller> findSellerInFollowings(User user, Long sellerId) {
        return user.getFollowing().stream()
                .filter(u -> u.getId().equals(sellerId))
                .findFirst();
    }

}
