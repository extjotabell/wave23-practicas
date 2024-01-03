package com.example.be_java_hisp_w23_g3.integration;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.example.be_java_hisp_w23_g3.util.PostRequestDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.ProductDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void createPostAndProduct_shouldReturnCreatedPost() throws Exception {
        // Creamos un ProductoDTO con un ID único (en este caso, 999L)
        ProductDTO productDTO = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(99L)
                .build();
        // Creamos un PostRequestDTO con el ProductoDTO creado anteriormente
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(productDTO)
                .build();
        //Se convierte el objeto PostRequestDTO a JSON para la solicitud
        String jsonRequest = objectMapper.writeValueAsString(postRequestDTO);

        mockMvc.perform(
                        post("/products/post")
                                .contentType(APPLICATION_JSON)
                                .content(jsonRequest))
                // Confirmamos el estatus de nuestra solicitud.
                .andExpect(status().isCreated())
                //Se verifica el tipo de contenido en la respuesta.
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(postRequestDTO.getUserId()))
                .andExpect(jsonPath("$.post_id").exists())
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.product").exists())
                .andExpect(jsonPath("$.category").exists())
                .andExpect(jsonPath("$.price").exists())
                .andExpect(jsonPath("$.product.product_id").value(productDTO.getProductId()))
                .andDo(print());
    }

    @Test
    @Order(2)
    void postProduct_shouldThrowNotFoundException() throws Exception {
        // Configuración del escenario de prueba: Crear un PostRequestDTO con un usuario inexistente(999)
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(999L)
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(101L)
                                .build()
                )
                .build();

        // Convertir el objeto PostRequestDTO a JSON para la solicitud
        String jsonRequest = objectMapper.writeValueAsString(postRequestDTO);

        // Realizar una solicitud POST para crear un post con un usuario inexistente
        mockMvc.perform(
                        post("/products/post")
                                .contentType(APPLICATION_JSON)
                                .content(jsonRequest))
                // Laa solicitud devuelve un código de estado 404 (Not Found)
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(
                        "User with id " + postRequestDTO.getUserId() + " not found"))
                .andDo(print());
    }


    @Test
    @Order(3)
    void createPostWithDuplicateProduct_shouldThrowAlreadyExistsException() throws Exception {
        // Intentamos crear un post con un producto que ya ha sido publicado
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(1L) // Aqui Usamos un producto ya existente.
                                .build()
                )
                .build();

        String jsonRequest = objectMapper.writeValueAsString(postRequestDTO);

        mockMvc.perform(
                        post("/products/post")
                                .contentType(APPLICATION_JSON)
                                .content(jsonRequest))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(
                        "Product with id " + postRequestDTO.getProduct().getProductId() + " already posted"))
                .andDo(print());
    }

}