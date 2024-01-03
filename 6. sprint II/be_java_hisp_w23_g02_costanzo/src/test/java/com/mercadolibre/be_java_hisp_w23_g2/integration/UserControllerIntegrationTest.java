package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.User;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("TI-0001: Test verifying the addition of a new post")
    void addPostIntegrationTest() throws Exception {
        PostDTO postIn = new PostDTO(2, LocalDate.now().minusWeeks(1), new ProductBasicDTO(1, "MacBook Pro", "Electronics", "Apple", "Silver", "Powerful laptop for professionals"), 1, 500.0);
        MessageDTO postOut = new MessageDTO("Publication successfully added.");

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String requestJson = writer.writeValueAsString(postIn);
        String responseJson = writer.writeValueAsString(postOut);

        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    @Test
    @DisplayName("TI-0002: Test that verifies the launching of the exception for creating a post that already exists")
    void addPostIntegrationExistPostException2Test() throws Exception {
        PostDTO postIn = new PostDTO(2, LocalDate.now().minusWeeks(1), new ProductBasicDTO(1, "MacBook Pro", "Electronics", "Apple", "Silver", "Powerful laptop for professionals"), 1, 500.0);
        MessageDTO postOut = new MessageDTO("The product id already exists.");

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String requestJson = writer.writeValueAsString(postIn);
        String responseJson = writer.writeValueAsString(postOut);

        // Add post
        this.mockMvc.perform(post("/products/post")
                .contentType("application/json")
                .content(requestJson));

        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    @Test
    @DisplayName("TI-0003: Test that verifies the count of followers for a specific user")
    void getFollowersCountIntegrationTest() throws Exception {
        UserFollowersCountDTO expected = new UserFollowersCountDTO(1, "John Doe", 2);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String expectedJson = writer.writeValueAsString(expected);

        this.mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }

    @Test
    @DisplayName("TI-0004: Test that verifies the functionality of following user")
    void followUserIntegrationTest() throws Exception {
        UserFollowedDTO expected = new UserFollowedDTO(2, "Alice Smith", List.of(new UserBasicDTO(1, "John Doe"), new UserBasicDTO(4, "Eve Wilson"), new UserBasicDTO(5, "Charlie Brown")));

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String expectedJson = writer.writeValueAsString(expected);

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }

    @Test
    @DisplayName("TI-0005: Test that verifies the triggering of the exception when following a user")
    void followUserExceptionIntegrationTest() throws Exception {
        MessageDTO expected = new MessageDTO("The user 2 already follow 4");

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String expectedJson = writer.writeValueAsString(expected);

        this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 4))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }

    @Test
    @DisplayName("TI-0006: Test that verifies the functionality of unfollowing user")
    void unfollowUserIntegrationTest() throws Exception {
        MessageDTO expected = new MessageDTO("Has stopped following Eve Wilson");

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String expectedJson = writer.writeValueAsString(expected);

        this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(expectedJson));
    }

}