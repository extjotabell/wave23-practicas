package com.mercadolibre.starwars.UnitTests.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class CharacterRepositoryTests {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Find characters")
    void findMatchingCharacters() {
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
        String query = "Luke";

        List<CharacterDTO> expectedResult = new ArrayList<>(List.of(character));
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        assertIterableEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Characters not found")
    void charactersNotFound() {
        String query = "Not found";
        List<CharacterDTO> expectedResult = new ArrayList<>(List.of());
        List<CharacterDTO> result = repository.findAllByNameContains(query);

        assertIterableEquals(expectedResult, result);
    }
}
