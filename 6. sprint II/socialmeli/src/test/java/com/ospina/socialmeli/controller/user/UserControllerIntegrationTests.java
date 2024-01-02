package com.ospina.socialmeli.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ospina.socialmeli.dto.response.FollowersListDTO;
import com.ospina.socialmeli.util.FollowersListDTOTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getFollowersList_shouldReturnFollowersListForValidUserIdAndOrder() throws Exception {
        Long userId = 8L;
        String order = "name_asc";

        FollowersListDTO followersListDTO = new FollowersListDTOTestDataBuilder()
                .followersListDTOWithFollowers().build();

        String followersListDTOJson = objectMapper.writeValueAsString(followersListDTO);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(followersListDTOJson))
                .andExpect(status().isOk());

    }

    @Test
    void getFollowersList_shouldReturnFollowersListForValidUserIdAndNoOrder() throws Exception {
        Long userId = 8L;

        FollowersListDTO followersListDTO = new FollowersListDTOTestDataBuilder()
                .followersListDTOWithFollowers().build();

        String followersListDTOJson = objectMapper.writeValueAsString(followersListDTO);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(followersListDTOJson))
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersList_shouldReturnBadRequestForInvalidUserId() throws Exception {
        Long userId = -1L;
        String order = "name_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowersList_shouldReturnBadRequestForInvalidOrder() throws Exception {
        Long userId = 1L;
        String order = "invalid_order";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowersCount_shouldReturnFollowersCountForValidUserId() throws Exception {
        Long userId = 8L;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersCount_shouldReturnBadRequestForInvalidUserId() throws Exception {
        Long userId = -1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowedSellerList_shouldReturnFollowedListForValidUserIdAndOrder() throws Exception {
        Long userId = 1L;
        String order = "name_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedSellerList_shouldReturnFollowedListForValidUserIdAndNoOrder() throws Exception {
        Long userId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedSellerList_shouldReturnBadRequestForInvalidUserId() throws Exception {
        Long userId = -1L;
        String order = "name_asc";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getFollowedSellerList_shouldReturnBadRequestForInvalidOrder() throws Exception {
        Long userId = 1L;
        String order = "invalid_order";

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnMessageResponseDTOForValidUserIds() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 8L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void followSeller_shouldReturnBadRequestForInvalidUserId() throws Exception {
        Long userId = -1L;
        Long userIdToFollow = 2L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void followSeller_shouldReturnBadRequestForInvalidUserIdToFollow() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = -1L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void unfollowSeller_shouldReturnMessageResponseDTOForValidUserIds() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = 8L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestForInvalidUserId() throws Exception {
        Long userId = -1L;
        Long userIdToUnfollow = 2L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void unfollowSeller_shouldReturnBadRequestForInvalidUserIdToUnfollow() throws Exception {
        Long userId = 1L;
        Long userIdToUnfollow = -1L;

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
