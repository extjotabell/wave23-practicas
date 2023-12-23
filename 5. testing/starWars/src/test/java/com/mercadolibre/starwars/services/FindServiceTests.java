package com.mercadolibre.starwars.services;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FindServiceTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    @Test
    @DisplayName("Return matching characters OK")
    void getCharactersByName() {
        // Arrange
        String query = "Darth";

        CharacterDTO darthVader = new CharacterDTO();
        CharacterDTO darthMaul = new CharacterDTO();
        darthVader.setName("Darth Vader");
        darthMaul.setName("Darth Maul");

        List<CharacterDTO> characters = new ArrayList<>(List.of(darthVader, darthMaul));

        // Act
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(characters.size(), result.size());
        assertEquals(characters.get(0).getName(), result.get(0).getName());
    }

    @Test
    @DisplayName("Return empty list when no characters match")
    void getCharactersByNameEmpty() {
        // Arrange
        String query = "Walter White";
        List<CharacterDTO> characters = new ArrayList<>();

        // Act
        when(characterRepository.findAllByNameContains(query)).thenReturn(characters);
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertTrue(result.isEmpty());
    }
}
