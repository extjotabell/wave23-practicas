package com.meli.ejercicioBlog.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.dtos.response.MessageResponseDTO;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class EntradaControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    public EntradaControllerIntegrationTest(){
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("Crear entrada valida")
    void crearValidoTest() throws Exception {
        EntradaBlogCreacionRequestDTO payload = new EntradaBlogCreacionRequestDTO(
                "unIdCualquiera",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        MessageResponseDTO expectedResult = new MessageResponseDTO("unIdCualquiera");
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
    @Test
    @DisplayName("Crear entrada invalida")
    void crearInvalidoTest() throws Exception {
        EntradaBlogCreacionRequestDTO payload = new EntradaBlogCreacionRequestDTO(
                null,
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/blog")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        MessageResponseDTO expectedResult = new MessageResponseDTO("null");
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));

        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
    @Test
    @DisplayName("Crear entrada existente")
    void crearExistenteTest(){

    }
}
