package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.socialmeli.dtos.response.FollowersCountDTO;
import com.meli.socialmeli.services.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserService userService;
    private static ObjectWriter objectWriter;

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0010: Usuario logra seguir al otro usuario con éxito.")
    void AddFollowerIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1100"
                ))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Usuario seguido agregado"));
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; " +
            "T-0011: Usuario no logra seguir al otro usuario porque ya lo esta siguiendo.")
    void AddFollowerItsFollowingIntegrationTest() throws Exception{
        // Arrange
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1100"
                ));
        // Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1100"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        jsonPath("$.message").value("El usuario ya sigue al usuario deseado")
                );
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0012: Usuario no puede seguirse a el mismo.")
    void AddFollowerTryFollowsItselfIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "100"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        jsonPath("$.message").value("Usuario inválido para seguir")
                );
    }

    @Test
    @DisplayName("/users/{userId}/follow/{userIdToFollow} ; T-0015: Usuario no puede seguir a usuario no existente.")
    void AddFollowerTryFollowInexistenUserIntegrationTest() throws Exception{
        // Arrange & Act & Assert
        this.mockMvc
                .perform(post(
                        "/users/{userId}/follow/{userIdToFollow}", "100", "1213"
                ))
                .andDo(print())
                .andExpectAll(
                        status().isBadRequest(),
                        content().contentType("application/json"),
                        jsonPath("$.message").value("Usuario a seguir no encontrado")
                );
    }

    @Test
    @DisplayName("/users/{userId}/followers/count ; T-0013: Usuario no tiene seguidores entonces el conteo es 0")
    void countFollowersIntegrationTest() throws Exception {
        // Arrange & Act
        String expected = objectWriter.writeValueAsString(new FollowersCountDTO(1100,"Dudley", 0));
        MvcResult mvcResult = this.mockMvc
                .perform(get(
                        "/users/{userId}/followers/count", "1100"
                ))
                .andDo(print())
        // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("/users/{userId}/followers/count ; T-0014: Usuario tiene seguidores entonces el conteo es mayor a cero")
    void countFollowersUserFollowsOtherUsersIntegrationTest() throws Exception {
        // Arrange & Act
        Integer user_id = 1100;
        String expected = objectWriter.writeValueAsString(new FollowersCountDTO(user_id, "Dudley", 3));
        List.of(100, 2100, 3100).forEach(i -> userService.followSeller(i, 1100));

        MvcResult mvcResult = this.mockMvc
                .perform(get(
                        "/users/{userId}/followers/count", "1100"
                ))
                .andDo(print())
                // Assert
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
