package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .writer().withDefaultPrettyPrinter();

    /*
        US-0005: Dar de alta una nueva publicación.
    */
    @Test
    @DisplayName("New post: Ok")
    void newPostOk() throws Exception{
        // Arrange
        // Preparing request
        int userId = 100;
        LocalDate date = LocalDate.now();
        ProductDTO productDTO = new ProductDTO(
                5000,
                "Test product",
                "Test type",
                "Test brand",
                "Test color",
                "Test notes"
        );
        PostDTO postDTO = new PostDTO(userId, LocalDate.now(), productDTO, 1, 10.0);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/products/post"
        )
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postDTO));

        MessageDTO expectedContent = new MessageDTO("The User "+ userId + " has created new post.");

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
    @DisplayName("New post: Usuario no encontrado")
    void newPostUsuarioNoEncontrado() throws Exception{
        // Arrange
        // Preparing request
        int userId = 9999;
        LocalDate date = LocalDate.now();
        ProductDTO productDTO = new ProductDTO(
                5000,
                "Test product",
                "Test type",
                "Test brand",
                "Test color",
                "Test notes"
        );
        PostDTO postDTO = new PostDTO(userId, LocalDate.now(), productDTO, 1, 10.0);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                        "/products/post"
                )
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(postDTO));

        MessageDTO expectedContent = new MessageDTO("Invalid user");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
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
