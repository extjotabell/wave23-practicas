package com.ospina.socialmeli.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ospina.socialmeli.dto.request.PostRequestDTO;
import com.ospina.socialmeli.util.PostRequestDTOTestDataBuilder;
import com.ospina.socialmeli.util.ProductDTOTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void postProduct_ReturnsCreatedResponseWithValidRequest() throws Exception {
        // Arrange
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(new ProductDTOTestDataBuilder().productDTOByDefault().withProductId(50L).build())
                .build();
        String postRequestDTOJson = objectMapper.writeValueAsString(postRequestDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postRequestDTOJson))
                .andExpect(status().isCreated());
    }

    @Test
    void postProduct_ReturnsBadRequestWithInvalidRequest() throws Exception {
        // Arrange
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(null)
                .build();
        String postRequestDTOJson = objectMapper.writeValueAsString(postRequestDTO);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postRequestDTOJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void followedPostsList_ReturnsOkResponseWithValidUserIdAndOrder() throws Exception {
        // Arrange
        Long userId = 1L;
        String order = "DATE_ASC";
        String url = String.format("/products/followed/%d/list?order=%s", userId, order);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk());
    }

    @Test
    void followedPostsList_ReturnsOkResponseWithValidUserIdAndNullOrder() throws Exception {
        // Arrange
        Long userId = 1L;
        String url = String.format("/products/followed/%d/list", userId);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isOk());
    }

    @Test
    void followedPostsList_ReturnsBadRequestWithInvalidOrder() throws Exception {
        // Arrange
        Long userId = 1L;
        String order = "INVALID_ORDER";
        String url = String.format("/products/followed/%d/list?order=%s", userId, order);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isBadRequest());
    }

    @Test
    void followedPostsList_ReturnsBadRequestWithNegativeUserId() throws Exception {
        // Arrange
        Long userId = -1L;
        String order = "DATE_ASC";
        String url = String.format("/products/followed/%d/list?order=%s", userId, order);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(status().isBadRequest());
    }
}
