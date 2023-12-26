package com.mercadolibre.starwars.IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
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

    // ObjectWriter to convert objects to JSON with specific serialization settings
    private final ObjectWriter objecTWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    
    @Test
    @DisplayName("Test method for retrieving a character")
    void getCharacterOKTestGet() throws Exception {
        // Create a list containing a new CharacterDTO for Luke Skywalker
        List<CharacterDTO> responseDTO = createNewCharacterLukeDTO();

        // Convert the response DTO to JSON
        String responseJson = this.objecTWriter.writeValueAsString(responseDTO);

        // Perform a GET request to retrieve a character and expect an OK response
        MvcResult mvcResult = this.mockMvc.perform(get("/{query}", "Luke Skywalker"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andReturn();

        // Verify that the correct response JSON is returned
        assertEquals(responseJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    /**
     * Private method to create a list containing a new CharacterDTO for Luke Skywalker.
     *
     * @return a list containing a new CharacterDTO for Luke Skywalker
     */
    private List<CharacterDTO> createNewCharacterLukeDTO() {
        // Create a new CharacterDTO for Luke Skywalker
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

        // Create a list containing the new CharacterDTO
        List<CharacterDTO> responseDTO = new ArrayList<>();
        responseDTO.add(characterDTO);

        return responseDTO;
    }
}
