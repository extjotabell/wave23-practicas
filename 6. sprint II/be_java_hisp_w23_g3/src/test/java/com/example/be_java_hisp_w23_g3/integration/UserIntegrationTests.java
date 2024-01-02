package com.example.be_java_hisp_w23_g3.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* In this case, the correct approach would be to configure an
in-memory database (like H2). This offers data isolation as the
database starts fresh and gets wiped out at the end of the execution,
ensuring that the tests do not interfere with the real data, and that
the tests run with a predictable state in an exact replication of the production
environment.

But, taking into account that so far it is not necessary to implement
any integrations with real databases, the mentioned approach will be dismissed.
*/

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFollowersList_shouldReturnValidPostsList() throws Exception {
        Long userId = 6L;

        mockMvc.perform(
                        get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followers").exists())
                .andDo(print());
    }

    @Test
    void getFollowersList_shouldReturnValidPostsListWithOrderParam() throws Exception {
        Long userId = 6L;
        String order = "name_asc";

        mockMvc.perform(
                        get("/users/{userId}/followers/list", userId)
                                .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followers").exists())
                .andDo(print());
    }

    @Test
    void getFollowersList_shouldThrowInvalidExceptionOrderParam() throws Exception {
        Long userId = 6L;
        String order = "invalid order param";

        mockMvc.perform(
                        get("/users/{userId}/followers/list", userId)
                                .param("order", order))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    void getFollowersList_shouldThrowNotFoundException() throws Exception {
        Long userId = 101L;

        mockMvc.perform(
                        get("/users/{userId}/followers/list", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Seller with id " + userId + " not found"))
                .andDo(print());
    }

    @Test
    void getFollowersCount_shouldReturnValidCount() throws Exception {
        Long userId = 6L;

        mockMvc.perform(
                        get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followers_count").exists())
                .andDo(print());
    }

    @Test
    void getFollowersCount_shouldThrowNotFoundException() throws Exception {
        Long userId = 101L;

        mockMvc.perform(
                        get("/users/{userId}/followers/count", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Seller with id " + userId + " not found"))
                .andDo(print());
    }

    @Test
    void getFollowedSellerList_shouldReturnValidSellersList() throws Exception {
        Long userId = 1L;

        mockMvc.perform(
                        get("/users/{userId}/followed/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followed").exists())
                .andDo(print());
    }

    @Test
    void getFollowedSellerList_shouldReturnValidSellersListWithOrderParam() throws Exception {
        Long userId = 1L;
        String order = "name_asc";

        mockMvc.perform(
                        get("/users/{userId}/followed/list", userId)
                                .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.followed").exists())
                .andDo(print());
    }

    @Test
    void getFollowedSellerList_shouldThrowInvalidExceptionOrderParam() throws Exception {
        Long userId = 1L;
        String order = "invalid order param";

        mockMvc.perform(
                        get("/users/{userId}/followed/list", userId)
                                .param("order", order))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    void getFollowedSellerList_shouldThrowNotFoundException() throws Exception {
        Long userId = 101L;

        mockMvc.perform(
                        get("/users/{userId}/followed/list", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User with id " + userId + " not found"))
                .andDo(print());
    }

    @Test
    void followSeller_shouldReturnValidMessage() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 9L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Following a new Seller!"))
                .andDo(print());
    }

    @Test
    void followSeller_shouldThrowAlreadyFollowingException() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 7L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("This seller is already part of your followings"))
                .andDo(print());
    }

    @Test
    void followSeller_shouldThrowFollowingMyselfException() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 1L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("You can't follow yourself"))
                .andDo(print());
    }

    @Test
    void followSeller_shouldThrowNotFoundExceptionBySeller() throws Exception {
        Long userId = 1L;
        Long userIdToFollow = 2L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Seller with id " + userIdToFollow + " not found"))
                .andDo(print());
    }

    @Test
    void followSeller_shouldThrowNotFoundExceptionByUser() throws Exception {
        Long userId = 101L;
        Long userIdToFollow = 6L;

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id " + userId + " not found"))
                .andDo(print());
    }

    @Test
    void unfollowSeller_shouldReturnValidMessage() throws Exception {
        Long userId = 1L;
        Long userIdToUnFollow = 6L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToUnFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("You have just unfollowed a seller"))
                .andDo(print());
    }

    @Test
    void unfollowSeller_shouldThrowNotFollowingException() throws Exception {
        Long userId = 1L;
        Long userIdToUnFollow = 10L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToUnFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Seller with id " + userIdToUnFollow + " is not part of your followings"))
                .andDo(print());
    }

    @Test
    void unfollowSeller_shouldThrowUnfollowingMyselfException() throws Exception {
        Long userId = 1L;
        Long userIdToUnFollow = 1L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToUnFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("You can't unfollow yourself"))
                .andDo(print());
    }

    @Test
    void unfollowSeller_shouldThrowNotFoundExceptionByUser() throws Exception {
        Long userId = 101L;
        Long userIdToUnFollow = 6L;

        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", userId, userIdToUnFollow)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User with id " + userId + " not found"))
                .andDo(print());
    }

}
