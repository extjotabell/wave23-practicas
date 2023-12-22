package com.example.star_wars;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class StarWarsApplicationIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findCharactersQueryIsValid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Luke")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"name\":\"Luke Skywalker\"}]"));
    }

    @Test
    void findCharactersQueryIsInvalid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Invalid")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

}
