package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTests {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService service;

    @Test
    public void findOkMultiple(){
        //Arrange
        String queryName = "Skywalker";
        List<CharacterDTO> expectedList = new ArrayList<>();
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
        expectedList.add(character1);

        CharacterDTO character2 = new CharacterDTO();
        character1.setName("Anakin Skywalker");
        character1.setHeight(188);
        character1.setMass(84);
        character1.setHair_color("blond");
        character1.setSkin_color("fair");
        character1.setEye_color("blue");
        character1.setBirth_year("41.9BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        expectedList.add(character2);

        CharacterDTO character3 = new CharacterDTO();
        character1.setName("Shmi Skywalker");
        character1.setHeight(163);
        character1.setHair_color("black");
        character1.setSkin_color("fair");
        character1.setEye_color("brow");
        character1.setBirth_year("72BBY");
        character1.setGender("female");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");
        expectedList.add(character3);

        Mockito.when(characterRepository.findAllByNameContains(queryName)).thenReturn(expectedList);
        int expected = expectedList.size();
        //Act
        int result = service.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findOkOne(){
        //Arrange
        String queryName = "Lobot";
        List<CharacterDTO> expectedList = new ArrayList<>();
        CharacterDTO character1 = new CharacterDTO();
        character1.setName("Lobot");
        character1.setHeight(175);
        character1.setMass(79);
        character1.setHair_color("none");
        character1.setSkin_color("light");
        character1.setEye_color("blue");
        character1.setBirth_year("37BBY");
        character1.setGender("male");
        character1.setHomeworld("Bespin");
        character1.setSpecies("Human");
        expectedList.add(character1);
        Mockito.when(characterRepository.findAllByNameContains(queryName)).thenReturn(expectedList);
        int expected = expectedList.size();
        //Act
        int result = service.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findOkNone(){
        //Arrange
        String queryName = "Mordor";
        List<CharacterDTO> expectedList = new ArrayList<>();
        Mockito.when(characterRepository.findAllByNameContains(queryName)).thenReturn(expectedList);
        int expected = expectedList.size();
        //Act
        int result = service.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

}
