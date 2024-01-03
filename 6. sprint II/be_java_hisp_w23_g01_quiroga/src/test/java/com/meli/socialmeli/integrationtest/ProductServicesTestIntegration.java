package com.meli.socialmeli.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc

public class ProductServicesTestIntegration {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd"))
            .writer();


    @Test
    @DisplayName("Integración de US-0005")
    void newPostProduct() throws Exception {

        // Arrange
        Integer userId = 100;
        ProductDTO newProduct = new ProductDTO(1, "Silla", "Mueble", "MSI", "Rojo", "Nuevo" );
        PostDTO post = new PostDTO(userId, LocalDate.now(), newProduct, 1, 2000.0);
        MessageDTO devolucion = new MessageDTO("El usuario "+ userId + " ha creado una nueva publicación.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType("application/json").content(writer.writeValueAsString(post));

        //Expected - Status, ContentType, Body.
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(devolucion));

        mockMvc.perform(request) // Ejecuta la request
                .andExpect(statusExpected) // cotejar que coincida body
                .andExpect(contentTypeExpected) // cotejar que coincida status
                .andExpect(bodyExpected) // cotejar que coincida contenttype
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Integración de US-0005 cuando usuario es inválido.")
    void newPostProductFailed () throws Exception {
        // Arrange
        Integer userId = 10;
        ProductDTO newProduct = new ProductDTO(1, "Silla", "Mueble", "MSI", "Rojo", "Nuevo" );
        PostDTO post = new PostDTO(userId, LocalDate.now(), newProduct, 1, 2000.0);
        MessageDTO devolucion = new MessageDTO("Usuario inválido.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType("application/json").content(writer.writeValueAsString(post));

        //Expected - Status, ContentType, Body.
        ResultMatcher statusExpected = MockMvcResultMatchers.status().is(404);
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(devolucion));

        mockMvc.perform(request) // Ejecuta la request
                .andExpect(statusExpected) // cotejar que coincida body
                .andExpect(contentTypeExpected) // cotejar que coincida status
                .andExpect(bodyExpected) // cotejar que coincida contenttype
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    @DisplayName("Integración de US - 0006 cuando no sigue a nadie")
    void getAllPostTwoLastWeeksWithoutFolloweds() throws Exception{

        //Arrange
        MessageDTO devolucion = new MessageDTO("El usuario con id: 1100 no sigue a nadie");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/1100/list");

        //Expected - Status, ContentType, Body.
        ResultMatcher statusExpected = MockMvcResultMatchers.status().is(404);
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(devolucion));
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(MockMvcResultHandlers.print());
    }
}

