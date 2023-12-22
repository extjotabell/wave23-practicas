package com.example.star_wars;

import com.example.star_wars.controller.StarWarsController;
import com.example.star_wars.dto.CharacterDTO;
import com.example.star_wars.entity.Character;
import com.example.star_wars.repository.CharacterRepository;
import com.example.star_wars.service.StarWarsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StarWarsApplicationTest {

    @MockBean
    private StarWarsService findService;

    @InjectMocks
    private StarWarsController findController;

    private CharacterRepository characterRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        characterRepository = new CharacterRepository();
    }

    @Test
    @DisplayName("findCharactersByQuery returns expected characters")
    void findCharacterTest() {
        String query = "Luke";
        CharacterDTO character = new CharacterDTO();
        character.setName("Luke Skywalker");
        List<CharacterDTO> expectedCharacters = Collections.singletonList(character);
        when(findService.filterByName(query)).thenReturn(expectedCharacters);

        List<CharacterDTO> actualCharacters = findController.filterByName(query).getBody();

        assertEquals(expectedCharacters, actualCharacters);
        verify(findService, times(1)).filterByName(query);
    }

    @Test
    @DisplayName("findCharactersByQuery returns empty list when no characters found")
    void findCharacterTestNotFound() {
        String query = "Harry Potter";
        when(findService.filterByName(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> actualCharacters = findController.filterByName(query).getBody();

        assertEquals(Collections.emptyList(), actualCharacters);
        verify(findService, times(1)).filterByName(query);
    }

    @Test
    public void findAllByNameContains_ReturnsMatchingCharacters() {
        List<Character> result = characterRepository.filterByName("Luke");
        assertFalse(result.isEmpty());
        result.forEach(characterDTO -> assertTrue(characterDTO.getName().toUpperCase().contains("LUKE")));
    }

    @Test
    public void findAllByNameReturnsEmptyListWhenNoMatch() {
        List<Character> result = characterRepository.filterByName("NonExistentCharacter");
        assertTrue(result.isEmpty());
    }

    @Test
    public void findAllByNameIgnoresCase() {
        List<Character> result = characterRepository.filterByName("luke");
        assertFalse(result.isEmpty());
        result.forEach(characterDTO -> assertTrue(characterDTO.getName().toUpperCase().contains("LUKE")));
    }
}
