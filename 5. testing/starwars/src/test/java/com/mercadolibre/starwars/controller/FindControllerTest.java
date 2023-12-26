package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findCharacterByName() {
        List<CharacterDTO> exptected = new ArrayList<>();
        when(findService.find("Luke")).thenReturn(exptected);

        List<CharacterDTO> result = findService.find("Luke");

        assertEquals(exptected, result);
    }

    @Test
    void findCharacterWhenNameIsNull() {
        String query = "Prueba";

        when(findService.find(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.find(query);

        assertEquals(0, result.size());
    }

    @Test
    void findCharacterWhenNameIsEmpty() {
        String query = "";

        when(findService.find(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.find(query);

        assertEquals(0, result.size());
    }
}
