package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;


    @Test
    @DisplayName("Find List name contains - non empty list")
    void findShouldReturnList(){
        //Arrange
        CharacterDTO characterOne = new CharacterDTO();
        CharacterDTO characterTwo = new CharacterDTO();
        characterOne.setName("MATCH ONE");
        characterTwo.setName("MATCH TWO");
        List<CharacterDTO> expectedResult = new ArrayList<>(List.of(characterOne, characterTwo));
        when(characterRepository.findAllByNameContains("MATCH")).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = findService.find("MATCH");

        //Assert
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Find List name contains -  empty list")
    void findShouldReturnEmptyList() {
        //Arrange
        List<CharacterDTO> expectedResult = new ArrayList<>();
        when(characterRepository.findAllByNameContains("MATCH")).thenReturn(expectedResult);

        //Act
        List<CharacterDTO> result = findService.find("MATCH");

        //Assert
        assertEquals(expectedResult, result);
        assertTrue(result.isEmpty());
    }

}