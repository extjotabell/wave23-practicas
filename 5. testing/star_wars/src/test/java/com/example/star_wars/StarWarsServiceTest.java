package com.example.star_wars;


import com.example.star_wars.dto.CharacterDTO;
import com.example.star_wars.entity.Character;
import com.example.star_wars.repository.CharacterRepository;
import com.example.star_wars.service.StarWarsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FindServiceTests {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private StarWarsService findService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findCharactersWhenQueryIsNotEmpty() {
        String query = "Luke";
        Character character = new Character();
        character.setName(query);
        when(characterRepository.filterByName(query)).thenReturn(Collections.singletonList(character));

        List<CharacterDTO> result = findService.filterByName(query);

        assertEquals(1, result.size());
        assertEquals(query, result.get(0).getName());
    }

    @Test
    void findCharactersWhenQueryIsEmpty() {
        String query = "";
        when(characterRepository.filterByName(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.filterByName(query);
        assertEquals(0, result.size());
    }

    @Test
    void findCharactersWhenQueryIsNull() {
        String query = null;
        when(characterRepository.filterByName(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> result = findService.filterByName(query);

        assertEquals(0, result.size());
    }
}
