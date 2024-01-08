package com.mercadolibre.starwars.IntegrationTests.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTests {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    FindService service;

    @Test
    @DisplayName("Get characters")
    void getCharacters() throws Exception {
        String query = "Luke";
        CharacterDTO characterOne = new CharacterDTO();
        characterOne.setName("Luke Skywalker");
        characterOne.setHeight(172);
        characterOne.setMass(77);
        characterOne.setHair_color("blond");
        characterOne.setSkin_color("fair");
        characterOne.setEye_color("blue");
        characterOne.setBirth_year("19BBY");
        characterOne.setGender("male");
        characterOne.setHomeworld("Tatooine");
        characterOne.setSpecies("Human");

        CharacterDTO characterTwo = new CharacterDTO();
        characterTwo.setName("Luke Skywalker Dos");
        characterTwo.setHeight(172);
        characterTwo.setMass(77);
        characterTwo.setHair_color("blond");
        characterTwo.setSkin_color("fair");
        characterTwo.setEye_color("blue");
        characterTwo.setBirth_year("19BBY");
        characterTwo.setGender("male");
        characterTwo.setHomeworld("Tatooine");
        characterTwo.setSpecies("Human");

        List<CharacterDTO> expectedResult = new ArrayList<>(List.of(characterOne, characterTwo));

        when(service.find(query)).thenReturn(expectedResult);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("Characters not found")
    void charactersNotFound() throws Exception {
        String query = "Luke";
        List<CharacterDTO> expectedResult = new ArrayList<>();

        when(service.find(query)).thenReturn(expectedResult);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }
}
