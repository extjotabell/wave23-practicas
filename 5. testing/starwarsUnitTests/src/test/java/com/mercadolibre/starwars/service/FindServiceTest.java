package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;
    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Test to verify the return of a CharacterDTO list ")
    void testFindServiceMethod() {
        // Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHeight(172);
        character1.setMass(77);
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        expectedCharacters.add(character1);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Vader");
        character2.setHeight(202);
        character2.setMass(136);
        character2.setHair_color("none");
        character2.setSkin_color("white");
        character2.setEye_color("yellow");
        character2.setBirth_year("41.9BBY");
        character2.setGender("male");
        character2.setHomeworld("Tatooine");
        character2.setSpecies("Human");
        expectedCharacters.add(character2);

        CharacterDTO character3 = new CharacterDTO();
        character3.setName("Anakin Skywalker");
        character3.setHeight(188);
        character3.setMass(84);
        character3.setHair_color("blond");
        character3.setSkin_color("fair");
        character3.setEye_color("blue");
        character3.setBirth_year("41.9BBY");
        character3.setGender("male");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        expectedCharacters.add(character3);

        CharacterDTO character4 = new CharacterDTO();
        character4.setName("Shmi Skywalker");
        character4.setHeight(163);
        character4.setMass(75);
        character4.setHair_color("black");
        character4.setSkin_color("fair");
        character4.setEye_color("brown");
        character4.setBirth_year("72BBY");
        character4.setGender("female");
        character4.setHomeworld("Tatooine");
        character4.setSpecies("Human");
        expectedCharacters.add(character4);

        Mockito.when(characterRepository.findAllByNameContains(query))
                .thenReturn(Arrays.asList(character1, character2, character3, character4));

        // Act
        List<CharacterDTO> actualCharacters = findService.find(query);

        // Assert
        assertEquals(expectedCharacters, actualCharacters);
    }

    @Test
    @DisplayName("Test to verify the quantity return of a CharacterDTO list")
    void testQuantityListFindServiceMethod() {
        // Arrange
        String query = "Skywalker";
        List<CharacterDTO> expectedCharacters = new ArrayList<>();
        int expectedQuantity;
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Luke Skywalker");
        character1.setHeight(172);
        character1.setMass(77);
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("19BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        expectedCharacters.add(character1);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Vader");
        character2.setHeight(202);
        character2.setMass(136);
        character2.setHair_color("none");
        character2.setSkin_color("white");
        character2.setEye_color("yellow");
        character2.setBirth_year("41.9BBY");
        character2.setGender("male");
        character2.setHomeworld("Tatooine");
        character2.setSpecies("Human");
        expectedCharacters.add(character2);

        CharacterDTO character3 = new CharacterDTO();
        character3.setName("Anakin Skywalker");
        character3.setHeight(188);
        character3.setMass(84);
        character3.setHair_color("blond");
        character3.setSkin_color("fair");
        character3.setEye_color("blue");
        character3.setBirth_year("41.9BBY");
        character3.setGender("male");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        expectedCharacters.add(character3);

        CharacterDTO character4 = new CharacterDTO();
        character4.setName("Shmi Skywalker");
        character4.setHeight(163);
        character4.setMass(75);
        character4.setHair_color("black");
        character4.setSkin_color("fair");
        character4.setEye_color("brown");
        character4.setBirth_year("72BBY");
        character4.setGender("female");
        character4.setHomeworld("Tatooine");
        character4.setSpecies("Human");
        expectedCharacters.add(character4);

        Mockito.when(characterRepository.findAllByNameContains(query))
                .thenReturn(expectedCharacters);
        expectedQuantity = expectedCharacters.size();
        // Act
        int totalCharacters = findService.find(query).size();

        // Assert
        assertEquals(expectedQuantity, totalCharacters);
    }

}