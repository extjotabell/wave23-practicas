package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    /*
    This before each function needs to be executed to load the implementations,
    in the case of an interface this is not necessary.
     */
    @BeforeEach
    void beforeEach() {
        openMocks(this);
    }

    @Test
    @DisplayName("FindController - find: Verofocar que los personajes devueltos sean correctos")
    void findTestCharacters() {
        // Arrange
        String queryParam = "Darth";

        CharacterDTO darthVader = new CharacterDTO();
        CharacterDTO darthMaul = new CharacterDTO();

        darthVader.setName("Darth Vader");
        darthMaul.setName("Darth Maul");

        List<CharacterDTO> characters = new ArrayList<>(
                List.of(
                        darthVader,
                        darthMaul
                )
        );
        //Act
        when(findService.find(queryParam)).thenReturn(characters);
        List<String> result = findController.find(queryParam).stream().map(CharacterDTO::getName).collect(Collectors.toList());
        //Assert
        assertEquals(characters.get(0).getName(), result.get(0));
        assertEquals(characters.get(1).getName(), result.get(1));
    }

    @Test
    @DisplayName("FindController - find: Verofocar que no devuelva personajes")
    void FindTestEmptyCharacters() {
        //Arrange
        String queryParam = "Fercho";
        List<CharacterDTO> expected = new ArrayList<>();
        //Act
        when(findService.find(queryParam)).thenReturn(expected);
        List<CharacterDTO> actual = findController.find(queryParam);
        // Assert
        assertEquals(expected, actual);
    }

}
