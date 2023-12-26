package org.ejercicio.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.ejercicio.starwars.dto.CharacterDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void findCharacterByNameIntegrationTest() throws Exception {
        List<CharacterDto> responseCharacters = new ArrayList<>();
        CharacterDto responseCharacter = new CharacterDto("Luke Skywalker", 172, 77, "male", "Tatooine", "Human");
        responseCharacters.add(responseCharacter);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(responseCharacters);

        MvcResult mvcResult = this.mockMvc.perform(get("/api/{name}", "Luke"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$").isArray())
                .andReturn();

        assertEquals(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8), payloadJson);
    }
}
