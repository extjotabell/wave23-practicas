package com.mercadolibre.starwars.integracion;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findTestSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/Darth")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[{\"name\":\"Darth Vader\",\"hair_color\":\"none\",\"skin_color\":\"white\",\"eye_color\":\"yellow\",\"birth_year\":\"41.9BBY\",\"gender\":\"male\",\"homeworld\":\"Tatooine\",\"species\":\"Human\",\"height\":202,\"mass\":136},{\"name\":\"Darth Maul\",\"hair_color\":\"none\",\"skin_color\":\"red\",\"eye_color\":\"yellow\",\"birth_year\":\"54BBY\",\"gender\":\"male\",\"homeworld\":\"Dathomir\",\"species\":\"Zabrak\",\"height\":175,\"mass\":80}]"));
    }

    @Test
    void findTestListEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ddsf")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }
}
