package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

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
    private static ObjectWriter objectWriter;

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer()
                .withDefaultPrettyPrinter();
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

}
