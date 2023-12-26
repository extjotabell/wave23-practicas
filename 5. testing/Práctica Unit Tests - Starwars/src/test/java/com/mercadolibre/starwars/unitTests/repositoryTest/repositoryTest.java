package com.mercadolibre.starwars.unitTests.repositoryTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class repositoryTest {

    @Autowired
    CharacterRepositoryImpl characterRepository;

    @Test
    @DisplayName("Test para el método: findAllByNameContains")
    void findAllByNameContains(){
        //Arrange
        String query = "Skywalker";
        //Act
        List<CharacterDTO> listObtained =characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertEquals(3, listObtained.size());
    }

    @Test
    @DisplayName("Test para el método: findAllByNameContains")
    void findAllByNameContains2(){
        //Arrange
        String query = "Chewbacca";
        List<CharacterDTO> expectedCharacters = createListCharactersDto();
        //Act
        List<CharacterDTO> listObtained =characterRepository.findAllByNameContains(query);
        //Assert
        Assertions.assertEquals(expectedCharacters, listObtained);
    }

    private List<CharacterDTO> createListCharactersDto() {
        return List.of(
                new CharacterDTO(
                        "Chewbacca",
                228,
                112,
                "brown",
                "NA",
                "blue",
                "200BBY",
                "male",
                "Kashyyyk",
                "Wookiee"
                )
        );
    }
}

//Arrange
//Act
//Assert