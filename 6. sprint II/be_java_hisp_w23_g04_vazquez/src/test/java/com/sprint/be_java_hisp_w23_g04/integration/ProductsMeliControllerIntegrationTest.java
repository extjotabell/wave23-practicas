package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostListDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductsMeliControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Save post")
    void test1() throws Exception {
        // Arrange
        PostDTO requestBody = new PostDTO(1, LocalDate.of(2022, 6, 18), new ProductDTO(1, "Azucar", "No perecedero", "Ledesma", "Blanco", "Rica"), 58, 1200.0);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(requestBody);

        // Act
        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("El post para el user: 1 se guardó exitosamente"));

    }

    @Test
    @DisplayName("Save post bad request")
    void test3() throws Exception {
        // Arrange
        PostDTO requestBody = new PostDTO();

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(requestBody);

        // Act
        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("Se encontraron los siguientes errores en las validaciones:"));

    }

    @Test
    @DisplayName("Get filtered post")
    void test2() throws Exception {
        // Arrange
        PostListDTO expectedResponse = new PostListDTO(4,
                List.of(
                        new PostResponseDTO(3, 4, LocalDate.of(2023, 12, 23), new ProductDTO(2, "Teclado", "Gamer", "Redragon", "Black", "Special Edition"), 58, 800.0),
                        new PostResponseDTO(1, 7, LocalDate.of(2023, 12, 29), new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1000.0),
                        new PostResponseDTO(1, 8, LocalDate.of(2023, 12, 31), new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 1000.0)
                )
        );

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(expectedResponse);

        // Act
        this.mockMvc.perform(get("/products/followed/{userId}/list", 4))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Get filtered post user id have not follow")
    void test4() throws Exception {
        // Act
        this.mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("El usuario indicado actualmente no sigue a ningún vendedor"));
    }

}
