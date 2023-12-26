package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @BeforeEach
    void setUp() {
        findService = new FindService(characterRepository);
    }

    @Test
    void findCharacterWhenExist(){
        // arrange
        String query = "Luke";
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke");
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.singletonList(characterDTO));

        // act
        List<CharacterDTO> result = findService.find(query);

        // assert
        assertEquals(1, result.size());
        assertEquals(query, result.get(0).getName());
    }

    @Test
    void findCharacterWhenNotExist(){
        // arrange
        String query = "Raul";
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // act
        List<CharacterDTO> result = findService.find(query);

        // assert
        assertEquals(0, result.size());
    }

    @Test
    void findCharacterWhenQueryIsNull(){
        // arrange
        String query = null;
        when(characterRepository.findAllByNameContains(query)).thenReturn(Collections.emptyList());

        // act
        List<CharacterDTO> result = findService.find(query);

        // assert
        assertEquals(0, result.size());
    }
}
