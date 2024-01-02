package com.ospina.socialmeli.repository.user;


import com.ospina.socialmeli.entity.user.Seller;
import com.ospina.socialmeli.entity.user.User;

import com.ospina.socialmeli.util.UserTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTests {
    private UserRepository repository;

    private User user;

    @BeforeEach
    void setUpTestData() {
        repository = new UserRepositoryImpl();
        user = new UserTestDataBuilder().userByDefault().build();
    }

    @Test
    void create_shouldCreateAndReturnUser() {
        User savedUser = repository.create(user);
        boolean isPresent = repository.read(user.getId()).isPresent();

        assertTrue(isPresent);
        assertTrue(areEquals(savedUser));
    }

    @Test
    void createAll_shouldCreateAllAndReturnUsers() {
        User user1 = new UserTestDataBuilder().userByDefault()
                .build();
        User user2 = new UserTestDataBuilder().userByDefault()
                .build();
        User user3 = new UserTestDataBuilder().userByDefault()
                .build();
        User user4 = new UserTestDataBuilder().userByDefault()
                .build();

        List<User> users = List.of(user1, user2, user3, user4);
        List<User> savedUsers = repository.createAll(users);

        assertEquals(users.size(), savedUsers.size());
    }

    @Test
    void read_shouldReturnSeller() {
        repository.create(user);

        User readUser = repository.read(user.getId()).orElse(null);

        assertNotNull(readUser);
    }

    @Test
    void read_shouldReturnEmpty() {
        Optional<User> readUser = repository.read(user.getId());

        assertTrue(readUser.isEmpty());
    }

    @Test
    void delete_shouldRemoveUser() {
        repository.create(user);

        repository.delete(user.getId());

        assertFalse(repository.read(user.getId()).isPresent());
    }

    @Test
    void findSellerInFollowings_shouldReturnSeller() {
        User userWithFollowings = new UserTestDataBuilder().userWithFollowings().build();
        repository.create(userWithFollowings);

        Optional<Seller> seller = repository.findSellerInFollowings(userWithFollowings,
                userWithFollowings.getFollowing().stream().toList().get(0).getId());

        assertTrue(seller.isPresent());
    }

    @Test
    void findSellerInFollowings_shouldReturnEmpty() {
        Optional<Seller> seller = repository.findSellerInFollowings(user, 1L);

        assertTrue(seller.isEmpty());
    }

    @Test
    void update_shouldUpdate() {
        User user2 = new UserTestDataBuilder().userByDefault()
                        .withUsername("Updated Username")
                        .build();

        repository.create(user);

        repository.update(user.getId(), user2);

        assertTrue(areEquals(user2));
    }

    private boolean areEquals(User o) {
        if (o == null) return false;
        return Objects.equals(o.getId(), user.getId()) &&
                Objects.equals(o.getUsername(), user.getUsername());
    }
}
