package com.meli.socialmeli.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.MessageDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.entities.User;
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

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static util.UserEntityUtilsGenerator.getNewPostAdd;

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
    void newPostProduct() throws Exception {

        //Arrange

        Integer userId = 100;

        ProductDTO newProduct = new ProductDTO(1, "Silla", "Mueble", "MSI", "Rojo", "Nuevo" );
        PostDTO post = new PostDTO(userId, LocalDate.now(), newProduct, 1, 2000.0);
        MessageDTO devolucion = new MessageDTO("El usuario "+ userId + " ha creado una nueva publicación.");


        //La request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post").contentType("application/json").content(writer.writeValueAsString(post));

        //Los expected

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExoected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(devolucion));

        mockMvc.perform(request) // Ejecuta la request
                .andExpect(statusExpected) // cotejar que coincida body
                .andExpect(contentTypeExoected) // cotejar que coincida status
                .andExpect(bodyExpected) // cotejar que coincida contenttype
                .andDo(MockMvcResultHandlers.print());
    }

}
