package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest //It initializes the Spring application context.
@AutoConfigureMockMvc //Is used to automatically configure a MockMvc instance, allowing for easier testing of MVC controllers in a Spring application.
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper() //To configure serialization options (JSON)
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Add a new post.")
    void addPost() throws Exception{
        PostDTO payloadRequestDTO = ObjectCreator.createPostWithProduct();
        MessageDTO payloadResponseDTO = new MessageDTO("Publication successfully added.");

        String payloadRequestJson = writer.writeValueAsString(payloadRequestDTO); // Converts DTO to JSON
        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        //Performs a POST request to the "/products/post" endpoint using the configured mockMvc instance.
        MvcResult result = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadRequestJson))
                .andDo(print()) // Print the request and response details for debugging purposes.
                .andExpect(status().isOk()) // Expecting HTTP status code 200 (OK).
                .andExpect(content().contentType("application/json")) // Expecting content type "application/json".
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage())) // Expecting a specific value in the JSON response body.
                .andReturn(); // Returns the result of the performed request.

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Add a new post. Exception: The product id already exists.")
    void addPostException() throws Exception{
        PostDTO payloadRequestDTO = ObjectCreator.createPostWithProduct();
        MessageDTO payloadResponseDTO = new MessageDTO("The product id already exists.");

        String payloadRequestJson = writer.writeValueAsString(payloadRequestDTO);
        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        //Performs a POST request to the "/products/post" endpoint using the configured mockMvc instance.
        MvcResult result = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadRequestJson))
                .andDo(print()) // Print the request and response details for debugging purposes.
                .andExpect(status().is4xxClientError()) // Expecting an HTTP 4xx status code (client error).
                .andExpect(content().contentType("application/json")) // Expecting content type "application/json".
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage())) // Expecting a specific value in the JSON response body.
                .andReturn(); // Returns the result of the performed request.

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());
    }

}
