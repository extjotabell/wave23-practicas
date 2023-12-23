package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Test to verify the return of a CharacterDTO")
    void testFindEndpoint() {
        // Arrange
        String query = "Luke";

        CharacterDTO expectedCharacter = new CharacterDTO();
        expectedCharacter.setName("Luke");

        Mockito.when(findService.find(query)).thenReturn(Collections.singletonList(expectedCharacter));

        // Act
        List<CharacterDTO> actualCharacters = findController.find(query);

        // Assert
        assertEquals(expectedCharacter.getName(), actualCharacters.get(0).getName());
        Mockito.verify(findService, Mockito.times(1)).find(query);
    }
}
