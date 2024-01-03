package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SellerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.utils.IntegrationUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserMeliControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void initialize() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .findAndRegisterModules()
                .writer();
    }

    /* Tests for followSellerUser() */

    @Test
    @DisplayName("FollowSellerUser successful integration test")
    void testFollowSellerUserOk() throws Exception {
        // params
        int userId = 5;
        int userIdToFollow = 8;

        SimpleMessageDTO messageDTO = new SimpleMessageDTO("El usuario con id:" + userId + " ahora sigue a vendedor con id:" + userIdToFollow);
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("FollowSellerUser fails because userId is zero and throw a BadRequestException")
    void testFollowSellerUserWithUserIdZero() throws Exception {
        // params
        int userId = 0;
        int userIdToFollow = 8;

        SimpleMessageDTO messageDTO = new SimpleMessageDTO(
                "Se encontraron los siguientes errores en las validaciones:",
                List.of("El id debe ser mayor a cero"));
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("FollowSellerUser fails because userId not exist and throw a NotFoundException")
    void testFollowSellerUserWhenUserNotExist() throws Exception {
        // params
        int userId = 99;
        int userIdToFollow = 8;

        SimpleMessageDTO messageDTO = new SimpleMessageDTO("No se encontró usuario con el id " + userId + ".");
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("FollowSellerUser fails because is the same userId and throw a BadRequestException")
    void testFollowSellerUserByThemself() throws Exception {
        // params
        int userId = 8;
        int userIdToFollow = 8;

        SimpleMessageDTO messageDTO = new SimpleMessageDTO("El usuario y vendedor con id:" + userId + " no pueden ser el mismo.");
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("FollowSellerUser fails because is non-seller userId and throw a BadRequestException")
    void testFollowNonSellerUser() throws Exception {
        // params
        int userId = 5;
        int userIdToFollow = 4;

        SimpleMessageDTO messageDTO = new SimpleMessageDTO("El id de usuario vendedor proporcionado no es valido.");
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /* Tests for getFollowers() */
    @Test
    @DisplayName("GetFollowers successful integration test")
    void testGetFollowersOk() throws Exception {
        // param
        int userId = 3;
        SellerDTO sellerDTO = new SellerDTO(userId, "Pablo Gonzalez", 2);
        String expectedResult = writer.writeValueAsString(sellerDTO);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("GetFollowers fails because userId is zero and throw a BadRequestException")
    void testGetFollowersWithUserIdZero() throws Exception {
        // param
        int userId = 0;
        SimpleMessageDTO messageDTO = new SimpleMessageDTO(
                "Se encontraron los siguientes errores en las validaciones:",
                List.of("El id del usuario debe ser mayor a cero"));
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("GetFollowers fails because userId not exist and throw a NotFoundException")
    void testGetFollowersWhenUserNotExist() throws Exception {
        // param
        int userId = 99;
        SimpleMessageDTO messageDTO = new SimpleMessageDTO("No se encontró usuario con el id " + userId + ".");
        String expectedResult = writer.writeValueAsString(messageDTO);

        MvcResult result = this.mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
