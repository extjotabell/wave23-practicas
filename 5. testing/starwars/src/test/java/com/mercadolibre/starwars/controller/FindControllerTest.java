package com.mercadolibre.starwars.controller;


import com.jayway.jsonpath.EvaluationListener;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    @DisplayName("Find list of characters with match")
    void findListOfCharactersShouldReturnNonEmptyList(){
        //Arrange
        CharacterDTO characterOne = new CharacterDTO();
        CharacterDTO characterTwo = new CharacterDTO();
        characterOne.setName("MATCH ONE");
        characterTwo.setName("MATCH TWO");
        List<CharacterDTO> expectedResult = new ArrayList<>(List.of(characterOne, characterTwo));
        when(findService.find("MATCH")).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = findController.find("MATCH");

        //Assert
        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Find list of characters with no match")
    void findListOfCharactersShouldReturnEmptyList(){
        //Arrange
        List<CharacterDTO> expectedResult = new ArrayList<>(List.of());
        when(findService.find("MATCH")).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = findController.find("MATCH");

        //Assert
        assertEquals(expectedResult, result);
        assertTrue(result.isEmpty());
    }
}