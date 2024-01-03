package com.example.be_java_hisp_w23_g3.integration.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class UserIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void followSeller_shouldWorkWhenSellerExists() throws Exception {
        //arrange
        Long userId = 2L;
        Long sellerIdToFollow = 9L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Following a new Seller!"));
    }

    @Test
    void followSeller_shouldThrowNotFoundException() throws Exception {
        //arrange
        Long userId = 99L;
        Long sellerIdToFollow = 9L;
        //act and assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with id "+userId+" not found"));
    }

    @Test
    void followSeller_shouldThrowFollowingMyselfException() throws Exception {
        //arrange
        Long userId = 2L;
        Long sellerIdToFollow = 2L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You can't follow yourself"));
    }

    @Test
    void followSeller_shouldThrowExceptionForInvalidUserId() throws Exception {
        //arrange
        Long userId = -2L;
        Long sellerIdToFollow = 9L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").value("The follower user_id must be greater than zero"));

    }
    @Test
    void followSeller_shouldThrowExceptionForInvalidUserIdToFollow() throws Exception {
        //act & assert
        Long userId = 2L;
        Long sellerIdToFollow = -9L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").value("The user_id to follow must be greater than zero"));

    }

    @Test
    void followSeller_shouldThrowAlreadyAFollowerException() throws Exception {
        //arrange
        Long userId = 1L;
        Long sellerIdToFollow = 6L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("This seller is already part of your followings"));
    }

    @Test
    void unfollowSeller_shouldWorkWhenSellerExistsOnFollowings() throws Exception {
        //arrange
        Long userId = 1L;
        Long sellerIdToUnFollow = 6L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You have just unfollowed a seller"));
    }

    @Test
    void unfollowSeller_shouldThrowNotAFollowerException() throws Exception {
        //arrange
        Long userId = 1L;
        Long sellerIdToUnFollow = 9L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Seller with id " + sellerIdToUnFollow + " is not part of your followings"));
    }

    @Test
    void unfollowSeller_shouldThrowUnFollowingMyselfException() throws Exception {
        //arrange
        Long userId = 1L;
        Long sellerIdToUnFollow = 1L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You can't unfollow yourself"));
    }

    @Test
    void unFollowSeller_shouldThrowExceptionForInvalidUserId() throws Exception {
        //arrange
        Long userId = -1L;
        Long sellerIdToUnFollow = 6L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").value("The follower user_id must be greater than zero"));

    }

    @Test
    void unFollowSeller_shouldThrowExceptionForInvalidUserIdToUnfollow() throws Exception {
        //arrange
        Long userId = 1L;
        Long sellerIdToUnFollow = -6L;
        //act & assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").value("The user_id to unfollow must be greater than zero"));

    }
    @Test
    void getFollowersCount_shouldGetCorrectResult() throws Exception {
        //arrange
        Long userId = 8L;
        //act & assert
        mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(4));
    }

}
