package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService service;
    @InjectMocks
    FindController controller;
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
    @DisplayName("Test find with only one result")
    void testFindOnlyOneResult() {
        String param = LUKE;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test find with multiple results")
    void testFindMultipleResults() {
        String param = DARTH;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test find with no result")
    void testFindNoResults() {
        String param = TEST;
        List<CharacterDTO> expectedResult = findAllByNameContains(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(0, result.size());
    }


    private List<CharacterDTO> findAllByNameContains(String query) {
        return database.stream()
                .filter(characterDTO -> matchWith(query, characterDTO))
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