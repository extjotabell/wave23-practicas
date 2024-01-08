package com.mercadolibre.starwars.UnitTests.service;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTests {
    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Get multiple name")
    void testFind() {
        String query = "Luke";

        CharacterDTO characterOne = new CharacterDTO();
        characterOne.setName("Luke Skywalker");
        characterOne.setHeight(172);
        characterOne.setMass(77);
        characterOne.setHair_color("blond");
        characterOne.setSkin_color("fair");
        characterOne.setEye_color("blue");
        characterOne.setBirth_year("19BBY");
        characterOne.setGender("male");
        characterOne.setHomeworld("Tatooine");
        characterOne.setSpecies("Human");

        CharacterDTO characterTwo = new CharacterDTO();
        characterTwo.setName("Luke Skywalker Dos");
        characterTwo.setHeight(172);
        characterTwo.setMass(77);
        characterTwo.setHair_color("blond");
        characterTwo.setSkin_color("fair");
        characterTwo.setEye_color("blue");
        characterTwo.setBirth_year("19BBY");
        characterTwo.setGender("male");
        characterTwo.setHomeworld("Tatooine");
        characterTwo.setSpecies("Human");

        List<CharacterDTO> charactersL1 = new ArrayList<>(List.of(characterOne, characterTwo));

        // arrange
        when(repository.findAllByNameContains(query)).thenReturn(charactersL1);

        // act
        List<CharacterDTO> charactersL2 = service.find(query);

        // assert
        verify(repository, atLeastOnce()).findAllByNameContains(query);
        assertIterableEquals(charactersL1, charactersL2);
    }
}
