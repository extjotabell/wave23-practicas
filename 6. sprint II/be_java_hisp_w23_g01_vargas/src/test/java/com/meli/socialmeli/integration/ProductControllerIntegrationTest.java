package com.meli.socialmeli.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .writer().withDefaultPrettyPrinter();

    @Test
    @DisplayName("POST: /products - Retorna confirmación de creación de producto")
    void createProductReturnConfirmation() throws Exception {
        //Arrange
        ProductDTO productDTO = new ProductDTO(111, "Camisa", "Camisa polo", "Polo", "blue", "algodon puro");
        PostDTO postDTO = new PostDTO(100, LocalDate.now(), productDTO, 1, 100000.0);

        String responseJSONExpected = "{'message': 'El usuario 100 ha creado una nueva publicación.'}";
        //Act - Assert
        mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(writer.writeValueAsString(postDTO))
                        .accept("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }
}
