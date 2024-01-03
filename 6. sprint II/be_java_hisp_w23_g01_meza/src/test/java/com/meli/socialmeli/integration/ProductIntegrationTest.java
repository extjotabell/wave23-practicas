package com.meli.socialmeli.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.socialmeli.dtos.request.PostDTO;
import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.repositories.IUserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static java.time.LocalDate.now;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter objectWriter;

    @Autowired
    private IUserRepository userRepository;

    @BeforeEach
    public void initialization() {
        userRepository.loadData();
    }

    @AfterEach
    public void clean() {
        userRepository.clearData();
    }

    @BeforeAll
    public static void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .writer();
    }

    @Test
    @DisplayName("/products - Confirmación de creación de producto ; T-")
    void createProductReturnConfirmation() throws Exception {
        //Arrange
        ProductDTO productDTO = new ProductDTO(
                1,
                "Computadora",
                "TI",
                "Asus",
                "Negro",
                "Multicore"
        );
        PostDTO postDTO = new PostDTO(100, now(), productDTO, 1, 100000.0);
        String responseJSONExpected = "{'message': 'El usuario 100 ha creado una nueva publicación.'}";
        //Act - Assert
        mockMvc.perform(post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(objectWriter.writeValueAsString(postDTO))
                        .accept(APPLICATION_JSON))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }


}
