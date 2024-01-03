package com.mercadolibre.romannumerals.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RomanNumeralsIntegrationTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Test numeros romanos")
    public void RomanNumeralsTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/{numbers}", 10))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("X")))
                .andReturn();
    }
}
