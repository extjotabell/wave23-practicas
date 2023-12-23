package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRepositoryTests {

    CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Return matching characters OK")
    void getCharactersByName() {
        // Arrange
        String query = "Skywalker";

        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);

        // Assert
        characters.forEach(character -> assertTrue(character.getName().toUpperCase().contains(query.toUpperCase())));
    }

    @Test
    @DisplayName("Return empty list when no characters match")
    void getCharactersByNameEmpty() {
        // Arrange
        String query = "Bad Bunny";

        // Act
        List<CharacterDTO> characters = characterRepository.findAllByNameContains(query);

        // Assert
        assertTrue(characters.isEmpty());
    }
}
