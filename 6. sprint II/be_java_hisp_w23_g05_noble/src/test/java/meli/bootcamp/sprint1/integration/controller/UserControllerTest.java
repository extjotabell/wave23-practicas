package meli.bootcamp.sprint1.integration.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("US-0002 Get sellers followers count integration test OK")
    void getFollowersCount() throws Exception {
        int userId = 1;
        FollowersDto response = new FollowersDto(1, "Ailen Pereira", 3);
        String jsonResponse = objectWriter.writeValueAsString(response);

        // Request
        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/count", userId)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(String.valueOf(jsonResponse)))
                .andDo(print());
    }

    @Test
    @DisplayName("US-0005 New post integration test OK")
    void newPostTestOk() throws Exception {
        NewProductDto product = new NewProductDto(1, "Silla", "Exterior", "Mor", "Azul", "Es muy comoda");
        NewPostDto payload = new NewPostDto(1, LocalDate.of(2024, 1, 1), product, 1, 500);
        BaseResponseDto response = new BaseResponseDto("Post added");

        String payloadJson = objectWriter.writeValueAsString(payload);
        String responseJson = objectWriter.writeValueAsString(response);

        // Request
        MvcResult result = this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US-0007 Unfollow user integration test OK")
    void unfollowUserTestOk() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 4;
        BaseResponseDto response = new BaseResponseDto("User " + userIdToUnfollow + " was unfollowed");
        String jsonResponse = objectWriter.writeValueAsString(response);

        // Request
        MockHttpServletRequestBuilder request = post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(String.valueOf(jsonResponse)))
                .andDo(print());
    }

    @Test
    @DisplayName("US-0007 Unfollow user integration test seller not followed")
    void unfollowUserTestUserNotFollowed() throws Exception {
        int userId = 2;
        int userIdToUnfollow = 1;
        BaseResponseDto response = new BaseResponseDto("Error unfollowing user, user " + userId + " doesn't follow user " + userIdToUnfollow);
        String jsonResponse = objectWriter.writeValueAsString(response);

    }
}
