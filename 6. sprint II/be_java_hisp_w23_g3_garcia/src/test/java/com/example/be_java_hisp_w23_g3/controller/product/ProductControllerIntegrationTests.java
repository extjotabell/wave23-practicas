package com.example.be_java_hisp_w23_g3.controller.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    void followedPostsList_returnsCorrectResponse() throws Exception{
        //Arrange
        Long userID = 1L;

        //Act and Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userID))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void followedPostList_returnsCorrectResponseWithOrderAsc() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "DATE_ASC";

        //Act and Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void followedPostList_returnsCorrectResponseWithOrderDesc() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "DATE_DESC";

        //Act and Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void followedPostList_throwsExceptionWithInvalidOrder() throws Exception{
        //Arrange
        Long userID = 1L;
        String order = "any other than name_asc or name_desc";

        //Act and Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors").value("Order field can only be DATE_ASC or DATE_DESC"));
    }

    @Test
    void followedPostList_throwsExceptionWithInvalidUserId() throws Exception{
        //Arrange
        Long userID = -1L;
        String order = "DATE_DESC";

        //Act and Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userID)
                        .param("order", order))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errors").value("El user_id debe ser mayor que cero"));
    }


}
