package com.mercadolibre.starwars.integral;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerTestIntegral {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getCharactersOk() throws Exception {
        //Arrange
        List<CharacterDTO> luke = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172,
                                 77));
        String queryName = "Luke";

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String jsonExpected = writer.writeValueAsString(luke);
        MvcResult result = mockMvc.perform(get("/{query}", queryName)).andExpect(status().isOk()).andDo(print())
                                  .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(),jsonExpected);
    }
    @Test
    void getCharactersNonOk() throws Exception {
        //Arrange
        String queryName = "No existe";

        MvcResult result = mockMvc.perform(get("/{query}", queryName)).andExpect(status().isOk()).andDo(print())
                                  .andReturn();

        Assertions.assertEquals(result.getResponse().getContentAsString(),"[]");
    }
}
