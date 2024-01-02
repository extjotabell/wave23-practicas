package com.example.be_java_hisp_w23_g3.integration.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void followSeller_shouldWorkWhenSellerExists() throws Exception {
        Long userId = 2L;
        Long sellerToFollowId = 9L;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerToFollowId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Following a new Seller!"));
    }

    @Test
    void followSeller_shouldThrowNotFoundException() throws Exception {
        Long userId = 99L;
        Long sellerToFollowId = 9L;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerToFollowId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User with id "+userId+" not found"));
    }

    @Test
    void followSeller_shouldThrowFollowingMyselfException() throws Exception {
        Long userId = 2L;
        Long sellerToFollowId = 2L;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerToFollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You can't follow yourself"));
    }

    @Test
    void followSeller_shouldThrowAlreadyAFollowerException() throws Exception {
        Long userId = 1L;
        Long sellerToFollowId = 6L;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId,sellerToFollowId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("This seller is already part of your followings"));
    }

    @Test
    void unfollowSeller_shouldWorkWhenSellerExistsOnFollowings() throws Exception {
        Long userId = 1L;
        Long sellerIdToUnFollow = 6L;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You have just unfollowed a seller"));
    }

    @Test
    void unfollowSeller_shouldThrowNotAFollowerException() throws Exception {
        Long userId = 1L;
        Long sellerIdToUnFollow = 9L;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Seller with id " + sellerIdToUnFollow + " is not part of your followings"));
    }

    @Test
    void unfollowSeller_shouldThrowUnFollowingMyselfException() throws Exception {
        Long userId = 1L;
        Long sellerIdToUnFollow = 1L;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId,sellerIdToUnFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("You can't unfollow yourself"));
    }






}
