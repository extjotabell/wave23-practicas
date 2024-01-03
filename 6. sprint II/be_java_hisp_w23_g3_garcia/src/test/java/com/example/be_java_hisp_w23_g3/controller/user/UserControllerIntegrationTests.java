package com.example.be_java_hisp_w23_g3.controller.user;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getFollowersList_shouldReturnFollowersList() throws Exception{
        //Arrange
        Long userID = 8L;

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersList_shouldAcceptedOrderDesc() throws Exception{
        //Arrange
        Long userID = 8L;
        String order = "NAME_DESC";

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersList_shouldAcceptedOrderAsc() throws Exception{
        //Arrange
        Long userID = 8L;
        String order = "NAME_ASC";

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersList_shouldThrowsExceptionInvalidOrderParameter() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "any other than name_asc or name_desc";

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/list", userID)
                        .param("order", order))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException))
                .andExpect(jsonPath("$.errors").value("Order field can only be NAME_ASC or NAME_DESC"));
    }

    @Test
    void getFollowersCount_shouldReturnFollowersCountForValidUserId() throws Exception{
        //Arrange
        Long userID = 8L;

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowersCount_shouldThrowExceptionInvalidUserId() throws Exception{
        //Arrange
        Long userID = -9L;

        //Act and Assert
        mockMvc.perform(get("/users/{userId}/followers/count", userID))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException))
                .andExpect(jsonPath("$.errors").value("The user_id must be greater than zero"));
    }

    @Test
    void getFollowedSellerList_shouldReturnFollowedSellerList() throws Exception{
        //Arrange
        Long userID = 1L;

        //Act and Assert
        mockMvc.perform(get("/users/{userID}/followed/list", userID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedSellerList_shouldAcceptedOrderAsc() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "NAME_ASC";

        //Act and Assert
        mockMvc.perform(get("/users/{userID}/followed/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedSellerList_shouldAcceptedOrderDesc() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "NAME_DESC";

        //Act and Assert
        mockMvc.perform(get("/users/{userID}/followed/list", userID)
                        .param("order", order)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getFollowedSellerList_shouldThrowsExceptionInvalidOrderParameter() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "any other than name_asc or name_desc";

        //Act and Assert
        mockMvc.perform(get("/users/{userID}/followed/list", userID)
                        .param("order", order))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException))
                .andExpect(jsonPath("$.errors").value("Order field can only be NAME_ASC or NAME_DESC"));
    }

    @Test
    void followSeller_shouldReturnMessageResponseDTOForValidUserId() throws Exception{
        //Arrange
        Long userID = 1L;
        Long userIDToFollow = 11L;

        //Act and Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userID, userIDToFollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void followSeller_shouldThrowExceptionForInvalidUserId() throws Exception{
        //Arrange
        Long userID = -1L;
        Long userIDToFollow = 8L;

        //Act and Assert
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userID, userIDToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException))
                .andExpect(jsonPath("$.errors").value("The follower user_id must be greater than zero"));
    }

    @Test
    void unFollowSeller_shouldReturnMessageResponseDTO() throws Exception{
        //Arrange
        Long userID = 1L;
        Long userIDToUnfollow = 8L;

        //Act and Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userID, userIDToUnfollow))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void unFollowSeller_shouldThrowExceptionForInvalidUserId() throws Exception{
        //Arrange
        Long userID = -1L;
        Long userIDToUnfollow = 8L;

        //Act and Assert
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userID, userIDToUnfollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ConstraintViolationException))
                .andExpect(jsonPath("$.errors").value("The follower user_id must be greater than zero"));
    }

}
