package meli.bootcamp.sprint1.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.LastPostsDto;
import meli.bootcamp.sprint1.dto.response.PostDto;
import meli.bootcamp.sprint1.dto.response.ProductDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class LastPostTest {
    @Autowired
    MockMvc mockMvc;
    ObjectWriter objecTWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Last posts ok test")
    void lastPostsOkTest() throws Exception {
        //TODO: Re ver que devuelve el endpoint para mockear expected correctamente
        List<PostDto> postDtoList = new ArrayList<>();

        PostDto postDto = new PostDto(1,1, LocalDate.now(),
                new ProductDto(1,"Silla Gamer", "Gamer", "Racer","Red Black","Special Edition"),
                1,1500.5);

        postDtoList.add(postDto);

        LastPostsDto expected = new LastPostsDto(4, postDtoList);

        String responseJson = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = this.mockMvc.perform(get("/products/followed/{userId}/list","4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Last posts id not found  test")
    void lastPostsIdNotFoundTest() throws Exception {
        BaseResponseDto expected = new BaseResponseDto("User not found");
        String responseJson = objecTWriter.writeValueAsString(expected);
        MvcResult mvcResult = this.mockMvc.perform(get("/products/followed/{userId}/list","1111"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Last posts empty list ok test")
    void lastPostsEmptyListOkTest() throws Exception {
        LastPostsDto expected = new LastPostsDto(1, Collections.emptyList());
        String responseJson = objecTWriter.writeValueAsString(expected);
        MvcResult mvcResult = this.mockMvc.perform(get("/products/followed/{userId}/list","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
}
