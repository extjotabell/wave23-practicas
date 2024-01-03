package com.example.be_java_hisp_w23_g3.repository.user;


import com.example.be_java_hisp_w23_g3.entity.user.Seller;
import com.example.be_java_hisp_w23_g3.entity.user.User;
import com.example.be_java_hisp_w23_g3.util.UserTestDataBuilder;
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
        // Arrange
        User savedUser = repository.create(user);

        // Act
        boolean isPresent = repository.read(user.getId()).isPresent();

        // Assert
        assertTrue(isPresent);
        assertTrue(areEquals(savedUser));
    }

    @Test
    void createAll_shouldCreateAllAndReturnUsers() {
        // Arrange
        User user1 = new UserTestDataBuilder().userByDefault().build();
        User user2 = new UserTestDataBuilder().userByDefault().build();
        User user3 = new UserTestDataBuilder().userByDefault().build();
        User user4 = new UserTestDataBuilder().userByDefault().build();
        List<User> users = List.of(user1, user2, user3, user4);

        // Act
        List<User> savedUsers = repository.createAll(users);

        // Assert
        assertEquals(users.size(), savedUsers.size());
    }

    @Test
    void read_shouldReturnSeller() {
        // Arrange
        repository.create(user);

        // Act
        User readUser = repository.read(user.getId()).orElse(null);

        // Assert
        assertNotNull(readUser);
    }

    @Test
    void read_shouldReturnEmpty() {
        // Arrange
        // No arrangement needed for this test

        // Act
        Optional<User> readUser = repository.read(user.getId());

        // Assert
        assertTrue(readUser.isEmpty());
    }

    @Test
    void delete_shouldRemoveUser() {
        // Arrange
        repository.create(user);

        // Act
        repository.delete(user.getId());

        // Assert
        assertFalse(repository.read(user.getId()).isPresent());
    }

    @Test
    void findSellerInFollowings_shouldReturnSeller() {
        // Arrange
        User userWithFollowings = new UserTestDataBuilder().userWithFollowings().build();
        repository.create(userWithFollowings);

        // Act
        Optional<Seller> seller = repository.findSellerInFollowings(userWithFollowings,
                userWithFollowings.getFollowing().stream().toList().get(0).getId());

        // Assert
        assertTrue(seller.isPresent());
    }

    @Test
    void findSellerInFollowings_shouldReturnEmpty() {
        // Arrange
        // No arrangement needed for this test

        // Act
        Optional<Seller> seller = repository.findSellerInFollowings(user, 1L);

        // Assert
        assertTrue(seller.isEmpty());
    }

    @Test
    void update_shouldUpdate() {
        // Arrange
        User user2 = new UserTestDataBuilder().userByDefault().withUsername("Updated Username").build();
        repository.create(user);

        // Act
        repository.update(user.getId(), user2);

        // Assert
        assertTrue(areEquals(user2));
    }

    private boolean areEquals(User o) {
        if (o == null) return false;
        return Objects.equals(o.getId(), user.getId()) &&
                Objects.equals(o.getUsername(), user.getUsername());
    }
}
