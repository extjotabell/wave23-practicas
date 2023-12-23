package com.mercadolibre.starwars.integrations;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Return matching characters OK")
    void findCharactersOk() throws Exception {
        // Arrange
        String query = "Luke";

        // Act and Assert
        mockMvc.perform(get("/" + query)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].name").value("Luke Skywalker"));
    }

    @Test
    @DisplayName("Return empty list when no characters match")
    void findCharactersEmpty() throws Exception {
        // Arrange
        String query = "Leo Messi";

        // Act and Assert
        mockMvc.perform(get("/" + query)
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isEmpty());
    }
}
