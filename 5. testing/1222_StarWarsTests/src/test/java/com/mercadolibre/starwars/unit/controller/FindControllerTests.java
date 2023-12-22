package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTests {

    @Mock
    FindService findService;

    @InjectMocks
    FindController controller;

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
        Mockito.when(findService.find(queryName)).thenReturn(expectedList);
        int expected = 1;
        //Act
        int result = controller.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

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
        character2.setName("Anakin Skywalker");
        character2.setHeight(188);
        character2.setMass(84);
        character2.setHair_color("blond");
        character2.setSkin_color("fair");
        character2.setEye_color("blue");
        character2.setBirth_year("41.9BBY");
        character2.setGender("male");
        character2.setHomeworld("Tatooine");
        character2.setSpecies("Human");
        expectedList.add(character2);

        CharacterDTO character3 = new CharacterDTO();
        character3.setName("Shmi Skywalker");
        character3.setHeight(163);
        character3.setHair_color("black");
        character3.setSkin_color("fair");
        character3.setEye_color("brow");
        character3.setBirth_year("72BBY");
        character3.setGender("female");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        expectedList.add(character3);
        int expected = expectedList.size();
        Mockito.when(findService.find(queryName)).thenReturn(expectedList);
        //Act
        int result = controller.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findOkNone(){
        //Arrange
        String queryName = "Mordor";
        List<CharacterDTO> expectedList = new ArrayList<>();
        Mockito.when(findService.find(queryName)).thenReturn(expectedList);
        int expected = expectedList.size();
        //Act
        int result = controller.find(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);

    }

}
