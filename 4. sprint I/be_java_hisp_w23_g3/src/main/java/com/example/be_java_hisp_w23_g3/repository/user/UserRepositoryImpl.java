package com.example.be_java_hisp_w23_g3.repository.user;

import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users;

    public UserRepositoryImpl() {
        this.users = new ArrayList<>();
    }

    @Override
    public void create(User entity) {
        users.add(entity);
    }

    @Override
    public Optional<User> read(Long aLong) {
        return users.stream().filter(user -> user.getId().equals(aLong)).findFirst();
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(Long aLong) {
        users.removeIf(user -> user.getId().equals(aLong));
    }

    @PostConstruct
    private void load() {
        users.addAll(List.of(
                User.build(1L, "user1"),
                User.build(2L, "user2"),
                User.build(3L, "user3"),
                User.build(4L, "user4"),
                User.build(5L, "user5"),
                User.build(6L, "user6")
        ));
    }
}
