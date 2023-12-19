package com.ospina.socialmeli.repository.user;

import com.ospina.socialmeli.entity.Seller;
import com.ospina.socialmeli.entity.User;
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
    public void update(User entity) {

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

    @PostConstruct
    private void load() {
        users.addAll(List.of(
                User.build(1L, "user1", new HashSet<>(Arrays.asList(
                        Seller.build(User.build(8L,"abcdef")),
                        Seller.build(User.build(9L,"bcdefg")),
                        Seller.build(User.build(10L,"cdefgh"))
                ))),
                User.build(2L, "user2"),
                User.build(3L, "user3"),
                User.build(4L, "user4"),
                User.build(5L, "user5"),
                User.build(6L, "user6")
        ));
    }
}
