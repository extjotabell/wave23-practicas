package com.mercadolibre.starwars.integration;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET ENDPOINT: Character list with match")
    void findCharacterListWithMatchShouldReturnList() throws Exception {
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", "Skywalker"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.hasSize(3)));
    }

    @Test
    @DisplayName("GET ENDPOINT: Character list with no match")
    void findCharacterListWithMatchShouldReturnEmptyList() throws Exception {
        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/{query}", "abcdefg"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", Matchers.hasSize(0)));
    }

}