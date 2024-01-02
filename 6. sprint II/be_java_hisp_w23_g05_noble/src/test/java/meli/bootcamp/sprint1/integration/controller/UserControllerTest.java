package meli.bootcamp.sprint1.integration.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import meli.bootcamp.sprint1.dto.request.NewPostDto;
import meli.bootcamp.sprint1.dto.request.NewProductDto;
import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import meli.bootcamp.sprint1.dto.response.FollowersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter objectWriter = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("US-0002 Get sellers followers count integration test OK")
    void getFollowersCount() throws Exception {
        int userId = 1;
        FollowersDto response = new FollowersDto(1, "Ailen Pereira", 3);
        String jsonResponse = objectWriter.writeValueAsString(response);

        // Request
        MockHttpServletRequestBuilder request = get("/users/{userId}/followers/count", userId)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(String.valueOf(jsonResponse)))
                .andDo(print());
    }
}
