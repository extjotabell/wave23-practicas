package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CharacterRepositoryImplTests {

    private CharacterRepository characterRepository;

    @BeforeEach
    public void setUp() {
        this.characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Find all by name constaints - existing string")
    void findAllByExistingNameContainsShouldReturnMatches(){
        //Act
        List<CharacterDTO> charactersResult = characterRepository.findAllByNameContains("Skywalker");
        //Assert
        assertNotNull(charactersResult);
        assertTrue(!charactersResult.isEmpty());
        charactersResult.forEach(c -> assertTrue(c.getName().contains("Skywalker")));
    }

    @Test
    @DisplayName("Find all by name constaints - Non existing string")
    void findAllByNonExistingNameContainsShouldReturnZeroMatches(){
        //Act
        List<CharacterDTO> charactersResult = characterRepository.findAllByNameContains("INVALID STRING");
        //Assert
        assertTrue(charactersResult.isEmpty());
    }

}
