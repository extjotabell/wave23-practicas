package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {
    @Autowired
    CharacterRepositoryImpl repository;

    @Test
    void findByNameTestCharactersExists() {
        //Arrange
        List<CharacterDTO> luke = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        String queryName = "Luke";
        //Act
        List<CharacterDTO> result = repository.findAllByNameContains(queryName);
        //Assert
        Assertions.assertEquals(luke,result);
    }

    @Test
    void findByNameTestCharactersNotExists() {
        //Arrange
        String queryName = "akakakakasd";
        //Act
        List<CharacterDTO> result = repository.findAllByNameContains(queryName);
        //Assert
        Assertions.assertTrue(result.isEmpty());
    }

}
