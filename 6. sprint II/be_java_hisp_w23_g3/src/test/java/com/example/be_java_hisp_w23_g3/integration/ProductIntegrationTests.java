package com.example.be_java_hisp_w23_g3.integration;

import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w23_g3.util.PostRequestDTOTestDataBuilder;
import com.example.be_java_hisp_w23_g3.util.ProductDTOTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* In this case, the correct approach would be to configure an
in-memory database (like H2). This offers data isolation as the
database starts fresh and gets wiped out at the end of the execution,
ensuring that the tests do not interfere with the real data, and that
the tests run with a predictable state in an exact replication of the production
environment.

But, taking into account that so far it is not necessary to implement
any integrations with real databases, the mentioned approach will be dismissed.
*/


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
    void postProduct_shouldReturnAndCreateAPost() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(101L)
                                .build()
                )
                .build();

        String jsonRequest = objectMapper.writeValueAsString(postRequestDTO);

        mockMvc.perform(
                post("/products/post")
                        .contentType(APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(postRequestDTO.getUserId()))
                .andExpect(jsonPath("$.post_id").exists())
                .andExpect(jsonPath("$.date").exists())
                .andExpect(jsonPath("$.product").exists())
                .andExpect(jsonPath("$.category").exists())
                .andExpect(jsonPath("$.price").exists())
                .andDo(print());
    }

    @Test
    @Order(2)
    void postProduct_shouldThrowAlreadyExistsException() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(1L)
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

    @Test
    @Order(3)
    void postProduct_shouldThrowNotFoundException() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withUserId(101L)
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(101L)
                                .build()
                )
                .build();

        String jsonRequest = objectMapper.writeValueAsString(postRequestDTO);

        mockMvc.perform(
                        post("/products/post")
                                .contentType(APPLICATION_JSON)
                                .content(jsonRequest))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value(
                        "User with id " + postRequestDTO.getUserId() + " not found"))
                .andDo(print());
    }

    @Test
    @Order(4)
    void postProduct_shouldThrowValidationExceptionWhenProductInvalid() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(null)
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
                        "Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    @Order(5)
    void postProduct_shouldThrowValidationExceptionWhenPriceInvalid() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withPrice(Double.MAX_VALUE)
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(101L)
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
                        "Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    @Order(6)
    void postProduct_shouldThrowValidationExceptionWhenDateInvalid() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTOTestDataBuilder()
                .postRequestDTOByDefault()
                .withProduct(
                        new ProductDTOTestDataBuilder()
                                .productDTOByDefault()
                                .withProductId(101L)
                                .build()
                )
                .build();


        ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(
                objectMapper.writeValueAsString(postRequestDTO));
        jsonNode.put("date", "");

        String jsonRequest = objectMapper.writeValueAsString(jsonNode);

        mockMvc.perform(
                        post("/products/post")
                                .contentType(APPLICATION_JSON)
                                .content(jsonRequest))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(
                        "Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    @Order(7)
    void followedPostsList_shouldReturnValidPostsList() throws Exception {
        Long userId = 1L;

        mockMvc.perform(
                        get("/products/followed/{userId}/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").exists())
                .andDo(print());
    }

    @Test
    @Order(8)
    void followedPostsList_shouldReturnValidPostsListWithOrderParam() throws Exception {
        Long userId = 1L;
        String order = "date_asc";

        mockMvc.perform(
                        get("/products/followed/{userId}/list", userId)
                                .param("order", order))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(userId))
                .andExpect(jsonPath("$.posts").exists())
                .andDo(print());
    }

    @Test
    @Order(9)
    void followedPostsList_shouldThrowInvalidExceptionOrderParam() throws Exception {
        Long userId = 1L;
        String order = "invalid order param";

        mockMvc.perform(
                        get("/products/followed/{userId}/list", userId)
                                .param("order", order))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Validation errors have occurred"))
                .andExpect(jsonPath("$.errors").exists())
                .andDo(print());
    }

    @Test
    @Order(10)
    void followedPostsList_shouldThrowNotFoundException() throws Exception {
        Long userId = 101L;

        mockMvc.perform(
                        get("/products/followed/{userId}/list", userId))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("User with id " + userId + " not found"))
                .andDo(print());
    }
}
