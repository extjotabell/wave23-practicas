package com.mercadolibre.be_java_hisp_w23_g2.repository;

import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    private UserRepository repository;

    @BeforeEach
    @AfterEach
    public void setUp() throws IOException {
        this.repository = new UserRepository();
    }

    @Test
    @DisplayName("Validates that the user is found by ID and names match.")
    void findUserByIdEquals() {
        // ARRANGE
        int userId = 1;

        // ACT
        User result = repository.findUserById(userId);

        // ASSERT
        assertEquals("John Doe", result.getUserName());
    }

    @Test
    @DisplayName("Validates that the user is found by ID and names do not match.")
    void findUserByIdNotEquals() {
        // ARRANGE
        int userId = 1;

        // ACT
        User result = repository.findUserById(userId);

        // ASSERT
        assertNotEquals("Arami Aquino", result.getUserName());
    }

    @Test
    @DisplayName("Validates the addition of a post to a user.")
    void addPost() {
        // ARRANGE
        int userId = 1;
        Post post = ObjectCreator.createPost(117, userId, LocalDate.now());
        User user = repository.findUserById(userId);

        // ACT
        Post result = repository.addPost(user, post);

        // ASSERT
        assertNotNull(result.getId());
        assertEquals(post, result);
        assertTrue(user.getPosts().contains(result));
    }

    @Test
    @DisplayName("Validates the follow operation between two users.")
    void followUser() {
        // ARRANGE
        int followerId = 1;
        int toFollowId = 2;

        User follower = repository.findUserById(followerId);
        User toFollow = repository.findUserById(toFollowId);

        // ACT
        User result = repository.followUser(followerId, toFollowId);

        // ASSERT
        assertNotNull(result.getId());
        assertEquals(follower, result);
        assertTrue(follower.getFollowed().contains(toFollow));
        assertTrue(toFollow.getFollowers().contains(follower));
    }

    @Test
    @DisplayName("Validates the unfollow operation between two users.")
    void unfollowUser() {
        // ARRANGE
        int followerId = 1;
        int toUnfollowId = 4;

        User follower = repository.findUserById(followerId);
        User toUnfollow = repository.findUserById(toUnfollowId);

        // ACT
        User result = repository.unfollowUser(follower, toUnfollow);

        // ASSERT
        assertNotNull(result.getId());
        assertEquals(toUnfollow, result);
        assertFalse(follower.getFollowed().contains(toUnfollow));
        assertFalse(toUnfollow.getFollowers().contains(follower));
    }
}
