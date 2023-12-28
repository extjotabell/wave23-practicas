package meli.bootcamp.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestUserController {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test: Endpoint products/post")
    void newPostTest() throws Exception {

        String requestJson = writer().writeValueAsString(generateNewPostDto());
        String responseJson = writer().writeValueAsString(generateBaseResponseDto("Post added"));

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(responseJson))
                .andReturn();
    }

    @Test
    @DisplayName("Test: Endpoint products/post, throws exception Category not found")
    void newPostTestNotOkCategory() throws Exception {

        String requestJson = writer().writeValueAsString(generateNewPostDtoCase1());
        String message = "Category not found";
        String responseJson = writer().writeValueAsString(generateBaseResponseDto(message));

        MvcResult mvcResult = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json(responseJson))
                .andExpect(jsonPath("$.message").value(message))
                .andReturn();
    }

    @Test
    @DisplayName("Test: Endpoint products/post, throws exception User not found")
    void newPostTestNotOkUser() throws Exception {

        String requestJson = writer().writeValueAsString(generateNewPostDtoCase2());
        String message = "User not found";
        String responseJson = writer().writeValueAsString(generateBaseResponseDto(message));

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().json(responseJson))
                .andExpect(jsonPath("$.message").value(message))
                .andReturn();
    }

    private ObjectWriter writer(){
        return  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

}
