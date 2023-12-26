package com.mercadolibre.starwars.unitarios.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    void findTestListOk() {
        String query = "Darth";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName(query);
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.singletonList(characterDTO));

        List<CharacterDTO> result = findService.find(query);

        assertEquals(1, result.size());
        assertEquals(query, result.get(0).getName());
    }

    @Test
    void findTestListEmpty() {
        String query = "";
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.find(query);

        assertEquals(0, result.size());
    }

    @Test
    void findTestNullQuery() {
        String query = null;
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.find(query);

        assertEquals(0, result.size());
    }
}
