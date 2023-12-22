package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class FindControllerTests {

    @MockBean
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("findCharactersByQuery returns expected characters")
    void findCharactersByQueryReturnsExpectedCharacters() {
        // Arrange
        String query = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        List<CharacterDTO> expectedCharacters = Collections.singletonList(character);
        when(findService.find(query)).thenReturn(expectedCharacters);

        // Act
        List<CharacterDTO> actualCharacters = findController.find(query);

        // Assert
        assertEquals(expectedCharacters, actualCharacters);
        verify(findService, times(1)).find(query);
    }

    @Test
    @DisplayName("findCharactersByQuery returns empty list when no characters found")
    void findCharactersByQueryReturnsEmptyListWhenNoCharactersFound() {
        // Arrange
        String query = "NonExistentCharacter";
        when(findService.find(query)).thenReturn(Collections.emptyList());

        // Act
        List<CharacterDTO> actualCharacters = findController.find(query);

        // Assert
        assertEquals(Collections.emptyList(), actualCharacters);
        verify(findService, times(1)).find(query);
    }
}