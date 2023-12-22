package com.mercadolibre.starwars.unit.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CharacterRepositoryImplTests {

    @Test
    public void findAllByNameContainsOk(){
        //Arrange
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
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
        //character3.setMass(1);
        character3.setHair_color("black");
        character3.setSkin_color("fair");
        character3.setEye_color("brown");
        character3.setBirth_year("72BBY");
        character3.setGender("female");
        character3.setHomeworld("Tatooine");
        character3.setSpecies("Human");
        expectedList.add(character3);
        //int expected = expectedList.size();
        List<CharacterDTO> expected = expectedList;
        //Act
        //List<CharacterDTO> result = characterRepository.findAllByNameContains(queryName);
        //int result = characterRepository.findAllByNameContains(queryName).size();
        List<CharacterDTO> result = characterRepository.findAllByNameContains(queryName);
        //Assert
        Assertions.assertEquals(expectedList, result);
    }



    @Test
    public void findAllByNameVoidList(){
        //Arrange
        String queryName = "Mordor";
        int expected = 0;
        CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();
        //Act
        int result = characterRepository.findAllByNameContains(queryName).size();
        //Assert
        Assertions.assertEquals(expected, result);
    }

}
