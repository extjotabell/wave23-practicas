package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();
    private List<CharacterDTO> database;
    // Params used into tests
    final private String LUKE = "Luke";
    final private String DARTH = "Darth";
    final private String TEST = "Test";

    @BeforeEach
    void initialize() {
        database = loadDataBase();
    }

    @Test
    @DisplayName("Test findAllByNameContains with only one result")
    void findAllByNameContainsOnlyOneResult() {
        String param = LUKE;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with multiple results")
    void findAllByNameContainsMultipleResults() {
        String param = DARTH;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with no results")
    void findAllByNameContainsNoResults() {
        String param = TEST;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with null value")
    void findAllByNameContainsWithNullValue() {
        String param = null;

        assertThrows(NullPointerException.class,
                () -> repository.findAllByNameContains(param));
    }

    private List<CharacterDTO> findAllByNameContains(String param) {
        return database.stream()
                .filter(characterDTO -> matchWith(param, characterDTO))
                .collect(Collectors.toList());
    }

    private boolean matchWith(String query, CharacterDTO characterDTO) {
        return characterDTO.getName().toUpperCase().contains(query.toUpperCase());
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {
        };
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}