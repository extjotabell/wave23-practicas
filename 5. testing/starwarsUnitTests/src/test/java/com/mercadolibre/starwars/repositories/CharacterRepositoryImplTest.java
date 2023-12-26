package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CharacterRepositoryImplTest {

    @Test
    @DisplayName("Test to verify the return of a CharacterDTO list")
    void testfindAllByNameContains(){
        // Arrange
        CharacterRepositoryImpl characterRepositoryImpl = new CharacterRepositoryImpl();
        List<CharacterDTO> expectedList = new ArrayList<>();
        CharacterDTO character1 = new CharacterDTO();

        character1.setName("Darth Vader");
        character1.setHeight(202);
        character1.setMass(136);
        character1.setHair_color("none");
        character1.setSkin_color("white");
        character1.setEye_color("yellow");
        character1.setBirth_year("41.9BBY");
        character1.setGender("male");
        character1.setHomeworld("Tatooine");
        character1.setSpecies("Human");

        expectedList.add(character1);

        CharacterDTO character2 = new CharacterDTO();
        character2.setName("Darth Maul");
        character2.setHeight(175);
        character2.setMass(80);
        character2.setHair_color("none");
        character2.setSkin_color("red");
        character2.setEye_color("yellow");
        character2.setBirth_year("54BBY");
        character2.setGender("male");
        character2.setHomeworld("Dathomir");
        character2.setSpecies("Zabrak");

        // Act
        List<CharacterDTO> actualList = characterRepositoryImpl.findAllByNameContains("Darth");
        // Assert
        assertEquals(expectedList.get(0).getName(), actualList.get(0).getName());
    }


    @Test
    @DisplayName("Test to verify the matchWith method")
    void testMatchWith() throws Exception {
        // Arrange
        CharacterRepositoryImpl characterRepositoryImpl = new CharacterRepositoryImpl();
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Darth Vader");

        // Act
        Method method = CharacterRepositoryImpl.class.getDeclaredMethod("matchWith", String.class, CharacterDTO.class);
        method.setAccessible(true);
        boolean matchResult = (boolean) method.invoke(characterRepositoryImpl, "darth", characterDTO);

        // Assert
        assertTrue(matchResult);
    }

    @Test
    @DisplayName("Test to verify the loadDataBase method")
    void testLoadDataBase() throws Exception {
        // Arrange
        CharacterRepositoryImpl characterRepositoryImpl = new CharacterRepositoryImpl();

        // Act
        Method method = CharacterRepositoryImpl.class.getDeclaredMethod("loadDataBase");
        method.setAccessible(true);
        List<CharacterDTO> result = (List<CharacterDTO>) method.invoke(characterRepositoryImpl);

        // Assert
        assertFalse(result.isEmpty());
    }
}
