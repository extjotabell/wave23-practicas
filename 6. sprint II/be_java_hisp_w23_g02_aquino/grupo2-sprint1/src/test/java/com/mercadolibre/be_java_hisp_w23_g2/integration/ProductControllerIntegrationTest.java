package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.PostsFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.entity.Post;
import com.mercadolibre.be_java_hisp_w23_g2.utils.Mapper;
import com.mercadolibre.be_java_hisp_w23_g2.utils.ObjectCreator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Add a new post.")
    void addPost() throws Exception{
        ProductBasicDTO productBasicDTO = new ProductBasicDTO();
        productBasicDTO.setId(1000);
        productBasicDTO.setBrand("Brand");
        productBasicDTO.setName("Name");
        productBasicDTO.setType("Type");
        productBasicDTO.setColor("color");
        productBasicDTO.setNotes("Notes");

        PostDTO payloadRequestDTO = new PostDTO();
        payloadRequestDTO.setUserId(1);
        payloadRequestDTO.setCategory(1);
        payloadRequestDTO.setDate(LocalDate.now());
        payloadRequestDTO.setPrice(10000.0);
        payloadRequestDTO.setProduct(productBasicDTO);

        MessageDTO payloadResponseDTO = new MessageDTO("Publication successfully added.");

        String payloadRequestJson = writer.writeValueAsString(payloadRequestDTO);
        String payloadResponseJson = writer.writeValueAsString(payloadResponseDTO);

        MvcResult result = mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadRequestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(payloadResponseDTO.getMessage()))
                .andReturn();

        assertEquals(payloadResponseJson, result.getResponse().getContentAsString());
    }

}
