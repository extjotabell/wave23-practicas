package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;

import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @Order(1)
    @DisplayName("Returns the number of followers of a user given their ID.")
    void getFollowersCountSellerIntegrationTest() throws Exception {
        UserFollowersCountDTO payloadResponseDTO = new UserFollowersCountDTO();
        payloadResponseDTO.setId(1);
        payloadResponseDTO.setUserName("John Doe");
        payloadResponseDTO.setFollowersCount(2);

        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(payloadResponseDTO.getId()))
                .andExpect(jsonPath("$.user_name").value(payloadResponseDTO.getUserName()))
                .andExpect(jsonPath("$.followers_count").value(payloadResponseDTO.getFollowersCount()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());
    }

    @Test
    @Order(2)
    @DisplayName("Returns the number of followers of a user given their ID. Exception: Current user not exists.")
    void getFollowersCountSellerExceptionIntegrationTest() throws Exception {
        MessageDTO payloadResponseDTO = new MessageDTO();
        payloadResponseDTO.setMessage("Current user with id = 100 not exists.");

        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", 100))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());
    }

    @Test
    @Order(3)
    @DisplayName("Follow a user given their id and the id of the user to follow.")
    void followUserIntegrationTest() throws Exception{
        List<UserBasicDTO> followedExpectedDTO = List.of(
                new UserBasicDTO(4, "Eve Wilson"),
                new UserBasicDTO(5, "Charlie Brown"),
                new UserBasicDTO(2, "Alice Smith")
        );

        UserFollowedDTO payloadResponseDTO = new UserFollowedDTO();
        payloadResponseDTO.setId(1);
        payloadResponseDTO.setUserName("John Doe");
        payloadResponseDTO.setFollowed(followedExpectedDTO);

        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(payloadResponseDTO.getId()))
                .andExpect(jsonPath("$.user_name").value(payloadResponseDTO.getUserName()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());

    }

    @Test
    @Order(4)
    @DisplayName("Follow a user given their id and the id of the user to follow. Exception: Follow himself.")
    void followUserIntegrationExceptionTest() throws Exception{
        MessageDTO payloadResponseDTO = new MessageDTO();
        payloadResponseDTO.setMessage("A user cannot follow/unfollow himself");

        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 1)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());

    }

    @Test
    @Order(5)
    @DisplayName("Follow a user given their id and the id of the user to follow. Exception: Already follow.")
    void followUserIntegrationException2Test() throws Exception{
        MessageDTO payloadResponseDTO = new MessageDTO();
        payloadResponseDTO.setMessage("The user 1 already follow 4");

        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 4)
                        .contentType("application/json"))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());

    }

}
