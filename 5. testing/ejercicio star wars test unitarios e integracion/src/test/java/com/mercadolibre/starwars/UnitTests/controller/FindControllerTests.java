package com.mercadolibre.starwars.UnitTests.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindControllerTests {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    @DisplayName("Find names")
    void getCharacterName() {
        // arrange
        String query = "Darth";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        character.setHeight(172);
        character.setMass(77);
        character.setHair_color("blond");
        character.setSkin_color("fair");
        character.setEye_color("blue");
        character.setBirth_year("19BBY");
        character.setGender("male");
        character.setHomeworld("Tatooine");
        character.setSpecies("Human");
        List<CharacterDTO> characters = new ArrayList<>();
        characters.add(character);

        when(service.find(query)).thenReturn(characters);

        // act
        List<CharacterDTO> readCharacters = controller.find(query);

        // assert
        verify(service, atLeastOnce()).find(query);
        assertEquals(characters, readCharacters);
    }

    @Test
    @DisplayName("Name not found")
    void nameNotFound() {
        // arrange
        String query = "Luke";

        List<CharacterDTO> characters = new ArrayList<>();

        when(service.find(query)).thenReturn(characters);

        // act
        List<CharacterDTO> readCharacters = controller.find(query);

        // assert
        verify(service, atLeastOnce()).find(query);
        assertEquals(characters, readCharacters);
    }
}
