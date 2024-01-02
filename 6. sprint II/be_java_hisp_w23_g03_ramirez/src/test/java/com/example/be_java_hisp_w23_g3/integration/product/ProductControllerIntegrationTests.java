package com.example.be_java_hisp_w23_g3.integration.product;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.example.be_java_hisp_w23_g3.entity.product.Product;
import com.example.be_java_hisp_w23_g3.util.PostRequestDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.PostResponseDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.ProductDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.ProductTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.mapper.PostMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class ProductControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper writer;

    @Test
    void postProduct_shouldReturnCorrectResponse() throws Exception {
        Long userId = 1L;
        Long productId = 99L;
        ProductDTO product = new ProductDTOTestDataBuilder().productDTOByDefault().withProductId(productId).build();
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder().postRequestDTOByDefault().withProduct(product).build();
        String payloadJson = writer.writeValueAsString(postRequestDTO);
        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.product.product_id").value(99))
                .andReturn();
    }

    @Test
    void followedPostsList_ReturnsCorrectResponseWithAscOrder() throws Exception {
        Long userId = 1L;
        String order ="DATE_ASC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.posts.[0].post_id").value(1))
                .andExpect(jsonPath("$.posts.[1].post_id").value(2))
                .andExpect(jsonPath("$.posts.[2].post_id").value(3))
                .andExpect(jsonPath("$.posts.[3].post_id").value(4));
    }

    @Test
    void followedPostsList_ReturnsCorrectResponseWithDescOrder() throws Exception {
        Long userId = 1L;
        String order ="DATE_DESC";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.posts.[0].post_id").value(4))
                .andExpect(jsonPath("$.posts.[1].post_id").value(3))
                .andExpect(jsonPath("$.posts.[2].post_id").value(2))
                .andExpect(jsonPath("$.posts.[3].post_id").value(1));
    }

    @Test
    void followedPostsList_ReturnsCorrectResponseWithInvalidOrder() throws Exception {
        Long userId = 1L;
        String order ="ALPHABETICAL";

        mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").value("Order field can only be DATE_ASC or DATE_DESC"));
    }

}
