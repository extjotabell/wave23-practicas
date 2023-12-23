package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @BeforeEach
    void setUp() { openMocks(this); }

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
        when(findService.find(query)).thenReturn(characters);
        List<CharacterDTO> result = findController.find(query);

        // Assert
        assertEquals(characters.size(), result.size());
        assertEquals(characters.get(0).getName(), result.get(0).getName());
    }

    @Test
    @DisplayName("Return empty list when no characters match")
    void getCharactersByNameEmpty() {
        // Arrange
        String query = "Arthur Morgan";
        List<CharacterDTO> characters = new ArrayList<>();

        // Act
        when(findService.find(query)).thenReturn(characters);
        List<CharacterDTO> result = findController.find(query);

        // Assert
        assertEquals(characters.size(), result.size());
    }
}
