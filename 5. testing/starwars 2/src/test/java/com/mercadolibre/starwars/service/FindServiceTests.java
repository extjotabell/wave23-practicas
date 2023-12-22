package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindServiceTests {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private FindService findService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findCharactersWhenQueryIsNotEmpty() {
        // Arrange
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(query);
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.singletonList(characterDTO));

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(1, result.size());
        assertEquals(query, result.get(0).getName());
    }

    @Test
    void findCharactersWhenQueryIsEmpty() {
        // Arrange
        String query = "";
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(0, result.size());
    }

    @Test
    void findCharactersWhenQueryIsNull() {
        // Arrange
        String query = null;
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // Act
        List<CharacterDTO> result = findService.find(query);

        // Assert
        assertEquals(0, result.size());
    }
}
