package com.mercadolibre.be_java_hisp_w23_g2.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.UserFollowersCountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test verifying the addition of a new post")
    void addPostIntegrationTest() throws Exception {
        PostDTO postIn = new PostDTO(2, LocalDate.now().minusWeeks(1), new ProductBasicDTO(1, "MacBook Pro", "Electronics", "Apple", "Silver", "Powerful laptop for professionals"), 1, 500.0);
        MessageDTO postOut = new MessageDTO("Publication successfully added.");

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String requestJson = writer.writeValueAsString(postIn);
        String responseJson = writer.writeValueAsString(postOut);

        this.mockMvc.perform(post("/products/post")
                        .contentType("application/json")
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

}