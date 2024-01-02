package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;
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
    public void update(Long id, User entity) {
        users.stream().filter(user -> user.getId().equals(id)).findFirst()
                .ifPresent(user -> {
                    user.setUsername(entity.getUsername());
                    user.setFollowing(entity.getFollowing());
                });
    }

    @Override
    public void delete(Long userId) {
        users.removeIf(user -> user.getId().equals(userId));
    }

    @Override
    public Optional<Seller> findSellerInFollowings(User user, Long sellerId) {
        return user.getFollowing().stream()
                .filter(u -> u.getId().equals(sellerId))
                .findFirst();
    }

}
