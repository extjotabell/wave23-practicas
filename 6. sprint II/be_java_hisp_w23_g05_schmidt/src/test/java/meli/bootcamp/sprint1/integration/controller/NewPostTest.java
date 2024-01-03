package meli.bootcamp.sprint1.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
class NewPostTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter objecTWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("New post test ok")
    void newPostTest() throws Exception {
        BaseResponseDto expected = new BaseResponseDto("Post added");

        NewPostDto postExpected = new NewPostDto(1, LocalDate.of(2023,12,29),
                new NewProductDto(1,"Sombrero","Sombrero","Sombrero","Gray","Spetial Edition")
                ,1,1500);

        String payloadJson = objecTWriter.writeValueAsString(postExpected);
        String expectedJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(expectedJson,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("New post user doesnt exist test")
    void newPostUserDoesntExistTest() throws Exception {

        NewPostDto expected = new NewPostDto(111, LocalDate.of(2023,12,29),
                new NewProductDto(1,"Hat","Clothes","Nike","Gray","Spetial Edition")
                ,1,1500);

        String payloadJson = objecTWriter.writeValueAsString(expected);

        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }
    @Test
    @DisplayName("New post category not found test")
    void newPostCategoryNotFoundTest() throws Exception {

        NewPostDto expected = new NewPostDto(1, LocalDate.of(2023,12,29),
                new NewProductDto(1,"Hat","Clothes","Nike","Gray","Spetial Edition")
                ,181283,1500);

        String payloadJson = objecTWriter.writeValueAsString(expected);

        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }


}
