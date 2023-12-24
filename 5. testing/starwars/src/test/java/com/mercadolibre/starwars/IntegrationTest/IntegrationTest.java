package com.mercadolibre.starwars.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void getCharacterOKTestGet() throws Exception{

        //como devuelve un characterDTO, preparamos:
        CharacterDTO characterDTO = new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );

        List<CharacterDTO> responseDTO = new ArrayList<>();
        responseDTO.add(characterDTO);

        //Segundo : deserializer to string - JSON manualmente
        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        //dato de salida
        String responseJson = objecTWriter.writeValueAsString(responseDTO);

        //when
        MvcResult mvcResult = this.mockMvc.perform(get("/{query}", "Luke Skywalker"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }
}
