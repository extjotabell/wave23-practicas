package com.example.be_java_hisp_w23_g3.integration;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.example.be_java_hisp_w23_g3.entity.product.Product;
import com.example.be_java_hisp_w23_g3.util.PostRequestDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.ProductDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void postProduct_shouldReturnCreatedAndCorrectResponse() throws Exception {
        Long userId = 1L;
        Long productId = 34L;
        Double price = 100.0;

        ProductDTO product = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(productId)
                .build();

        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(userId)
                .withProduct(product)
                .withPrice(price)
                .build();

        mockMvc.perform(post("/products/post")
            .contentType("application/json")
            .content(mapper.writeValueAsString(postRequestDTO)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.user_id").value(userId))
            .andExpect(jsonPath("$.price").value(postRequestDTO.getPrice()));
    }

    @Test
    void postProduct_shouldReturnBadRequestWhenAFieldIsInvalid() throws Exception {
        Long userId = -1L;
        Long productId = -8L;
        String productName = "!!#$ˆ#@&!";
        Double price = 11000000.0;

        ProductDTO product = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(productId)
                .withProductName(productName)
                .build();

        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(userId)
                .withProduct(product)
                .withPrice(price)
                .build();

        mockMvc.perform(post("/products/post")
            .contentType("application/json")
            .content(mapper.writeValueAsString(postRequestDTO)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void postProduct_shouldReturnBadRequestWhenAFieldIsBlank() throws Exception {
        Long userId = 1L;
        Long productId = 10L;
        String productName = "";

        ProductDTO product = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(productId)
                .withProductName(productName)
                .build();

        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(userId)
                .withProduct(product)
                .build();

        mockMvc.perform(post("/products/post")
            .contentType("application/json")
            .content(mapper.writeValueAsString(postRequestDTO)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void postProuct_shouldReturnBadRequestWhenProdutIsAlreadyPosted() throws Exception {
        Long userId = 1L;
        Long productId = 1L; // This product is already posted in the sample data

        ProductDTO product = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(productId)
                .build();

        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(userId)
                .withProduct(product)
                .build();

        mockMvc.perform(post("/products/post")
            .contentType("application/json")
            .content(mapper.writeValueAsString(postRequestDTO)))
            .andExpect(status().isBadRequest());
    }

    @Test
    void postProduct_shouldReturnNotFoundWhenUserNotExists() throws Exception {
        Long userId = 100L;
        Long productId = 34L;

        ProductDTO product = new ProductDTOTestDataBuilder()
                .productDTOByDefault()
                .withProductId(productId)
                .build();

        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(userId)
                .withProduct(product)
                .build();

        mockMvc.perform(post("/products/post")
            .contentType("application/json")
            .content(mapper.writeValueAsString(postRequestDTO)))
            .andExpect(status().isNotFound());
    }

    @Test
    void followedPostsList_shouldReturnOkAndCorrectResponseInDateAsc() throws Exception {
        Long userId = 1L;
        String order = "DATE_ASC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user_id").value(userId))
            .andExpect(jsonPath("$.posts").isArray())
            .andExpect(jsonPath("$.posts[0].post_id").value(1))
            .andExpect(jsonPath("$.posts[0].product.product_id").value(1));
    }

    @Test
    void followedPostsList_shouldReturnOkAndCorrectResponseInDateDesc() throws Exception {
        Long userId = 1L;
        String order = "DATE_DESC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user_id").value(userId))
            .andExpect(jsonPath("$.posts").isArray())
            .andExpect(jsonPath("$.posts[0].post_id").value(4))
            .andExpect(jsonPath("$.posts[0].product.product_id").value(4));
    }

    @Test
    void followedPostsList_shouldReturnOkAndCorrectResponseInDefaultOrder() throws Exception {
        Long userId = 1L;

        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.user_id").value(userId))
            .andExpect(jsonPath("$.posts").isArray())
            .andReturn();

        String content = result.getResponse().getContentAsString();
        int arraySize = content.split("post_id").length - 1;
        assertEquals(4, arraySize);
    }

    @Test
    void followedPostsList_shouldReturnNotFoundWhenUserNotExists() throws Exception {
        Long userId = 100L;
        String order = "DATE_ASC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isNotFound());
    }

    @Test
    void followedPostsList_shouldReturnBadRequestWhenOrderIsInvalid() throws Exception {
        Long userId = 1L;
        String order = "INVALID_ORDER";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isBadRequest());
    }

    @Test
    void followedPostsList_shouldReturnBadRequestWhenUserIdIsInvalid() throws Exception {
        Long userId = -1L;
        String order = "DATE_ASC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
            .contentType("application/json")
            .param("order", order))
            .andExpect(status().isBadRequest());
    }
}
