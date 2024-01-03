package com.sprint.be_java_hisp_w23_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsMeliController {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Save post: Successful")
    void savePostOkTest() throws Exception {
        PostDTO requestBody = new PostDTO(1, LocalDate.of(2024, 1, 1),
                new ProductDTO(1, "Arroz", "Carolina", "Gallo",
                        "Blanco", "sin tacc"), 58, 1200.0);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(requestBody);
        String expectedDescription = "El post para el user: 1 se guardó exitosamente";
        // Act & Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value(expectedDescription));
    }

    @Test
    @DisplayName("Save post: Fails with Bad Request when validation fails")
    void savePostExceptionTest() throws Exception {
        PostDTO requestBody = new PostDTO(1, LocalDate.of(2024, 1, 1),
                new ProductDTO(1, "A##??", "Carolina", "Gallo",
                        "Blanco", "sin tacc"), 58, 1200.0);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());

        writer.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

        String payloadJson = writer.writeValueAsString(requestBody);
        String expectedDescription = "Se encontraron los siguientes errores en las validaciones:";
        String expectedValidation = "El campo no puede poseer caracteres especiales";
        // Act & Assert
        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value(expectedDescription))
                .andExpect(jsonPath("$.messages", hasSize(1)))
                .andExpect(jsonPath("$.messages", contains(expectedValidation)));
    }
}
