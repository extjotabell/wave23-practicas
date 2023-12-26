package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CharacterRepositoryTest {
    CharacterRepository characterRepository;

    CharacterRepositoryImpl characterRepositoryImpl;

    @BeforeEach
    @AfterEach
    private void setUp() {
        characterRepository = new CharacterRepositoryImpl();

        characterRepositoryImpl = new CharacterRepositoryImpl();
    }

    @Test
    void findAllByNameContains() {
        // arrange
        String query = "luke";

        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // assert
        assert result.size() == 1;
    }

    @Test
    void findAllByNameContainsWhenQueryIsEmpty() {
        // arrange
        String query = "";

        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // assert
        assert !result.isEmpty();
    }

    @Test
    void findAllByNameContainsWhenQueryIsNotInDatabase() {
        // arrange
        String query = "not exist";

        // act
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        // assert
        assert result.isEmpty();
    }

    @Test
    void findAllByNameIgnoreCaseContains() {
        // arrange
        String query = "LUKE";

        // act
        List<CharacterDTO> result = characterRepositoryImpl.findAllByNameContains(query);

        // assert
        assert result.size() == 1;
    }

}
