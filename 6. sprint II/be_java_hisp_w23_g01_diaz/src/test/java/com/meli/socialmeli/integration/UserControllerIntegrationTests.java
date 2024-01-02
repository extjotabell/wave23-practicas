package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.socialmeli.dtos.response.MessageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper writer = new ObjectMapper();

    @Test
    @DisplayName("Follow seller: Ok")
    void followSellerOk() throws Exception{
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario seguido agregado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Seguidor no encontrado")
    void followSellerInvalidFollower() throws Exception {
        //Arrange

        //Preparing request
        int userId = 9999;
        int userIdToFollow = 1100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario seguidor no encontrado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Usuario a seguir no encontrado")
    void followSellerInvalidFollowed() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 9999;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario a seguir no encontrado");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Usuario a seguir sin posts")
    void followSellerWithoutPosts() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 5100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario inválido para seguir");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Followe seller: Mismo usuario")
    void followSellerSameUser() throws Exception {
        //Arrange

        //Preparing request
        int userId = 100;
        int userIdToFollow = 100;
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/users/{userId}/follow/{userIdToFollowe}",
                userId,
                userIdToFollow
        );

        MessageDTO expectedContent = new MessageDTO("Usuario inválido para seguir");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentTypeExpectecd = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedContent));
        //Act % Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpectecd)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
