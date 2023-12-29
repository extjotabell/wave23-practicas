package com.example.be_java_hisp_w23_g3.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void getFollowersList_shouldReturnOkAndCorrectList() throws Exception {
        Long userId = 6L;

        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", userId)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        int arraySize = content.split("user_id").length - 1;
        assertEquals(3, arraySize);
    }

    @Test
    void getFollowersList_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowersList_shouldReturnNotFoundWhenUserIsInexistent() throws Exception {
        Long userId = 99L;

        mockMvc.perform(get("/users/{userId}/followers/list", userId)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void getFollowersCount_shouldReturnOkAndCorrectCount() throws Exception {
        Long userId = 6L;

        mockMvc.perform(get("/users/{userId}/followers/count", userId)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    void getFollowersCount_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;

        mockMvc.perform(get("/users/{userId}/followers/count", userId)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowersCount_shouldReturnNotFoundWhenUserIsInexistent() throws Exception {
        Long userId = 99L;

        mockMvc.perform(get("/users/{userId}/followers/count", userId)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void getFollowedSellerList_shouldReturnOkAndCorrectList() throws Exception {
        Long userId = 2L;
        String order = "NAME_ASC";

        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        int arraySize = content.split("user_id").length - 1;
        assertEquals(3, arraySize);
    }

    @Test
    void getFollowedSellerList_shouldReturnOkAndCorrectListInDescendingOrder() throws Exception {
        Long userId = 1L;
        String order = "NAME_DESC";

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.followed[0].user_id").value(7));
    }

    @Test
    void getFollowedSellerList_shouldReturnOkAndCorrectListInDefaultOrder() throws Exception {
        Long userId = 1L;

        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        int arraySize = content.split("user_id").length - 1;
        assertEquals(4, arraySize);
    }

    @Test
    void getFollowedSellerList_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;
        String order = "NAME_ASC";

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowedSellerList_shouldReturnNotFoundWhenUserIsInexistent() throws Exception {
        Long userId = 99L;
        String order = "NAME_ASC";

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isNotFound());
    }

    @Test
    void getFollowedSellerList_shouldReturnBadRequestWhenOrderIsInvalid() throws Exception {
        Long userId = 1L;
        String order = "INVALID_ORDER";

        mockMvc.perform(get("/users/{userId}/followed/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnOkAndCorrectMessage() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 10L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isOk());
    }

    @Test
    void followSeller_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;
        Long userIdToFollow = 10L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnNotFoundWhenUserIsInexistent() throws Exception {
        Long userId = 99L;
        Long userIdToFollow = 10L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void followSeller_shouldReturnBadRequestWhenUserIdToFollowIsInvalid() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = -1L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnNotFoundWhenUserToFollowIsInexistent() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 99L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void followSeller_shouldReturnBadRequestWhenUserToFollowIsAlreadyFollowed() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 6L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnBadRequestWhenFollowingMyself() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 1L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnNotFoundWhenUserToFollowIsNotASeller() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 2L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void unfollowSeller_shouldReturnOkAndCorrectMessage() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = 8L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isOk());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;
        Long userIdToUnfollow = 8L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void unfollowSeller_shouldReturnNotFoundWhenUserIsInexistent() throws Exception {
        Long userId = 99L;
        Long userIdToUnfollow = 8L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isNotFound());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestWhenUserIdToUnfollowIsInvalid() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = -1L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestWhenUserToUnfollowIsNotFollowed() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = 10L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestWhenUnfollowingMyself() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = 1L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
            .contentType("application/json"))
            .andExpect(status().isBadRequest());
    }
}
