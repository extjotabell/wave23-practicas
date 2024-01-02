package com.meli.socialmeli.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET: /users - Return a list of users")
    void getAllUsersShouldReturnList() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/users")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("POST: /users/{userId}/follow/{userIdToFollow} - Ok Return confirmation")
    void followSellerShouldReturnConfirmation() throws Exception {
        //Arrange
        String responseJSONExpected = "{'message': 'Usuario seguido agregado'}";

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/4100/follow/2100")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

}
