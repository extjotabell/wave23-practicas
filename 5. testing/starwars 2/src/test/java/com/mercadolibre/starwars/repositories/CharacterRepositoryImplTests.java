package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CharacterRepositoryImplTests {
    private CharacterRepositoryImpl characterRepository;

    @BeforeEach
    public void setup() {
        characterRepository = new CharacterRepositoryImpl();
    }

    @Test
    public void findAllByNameContains_ReturnsMatchingCharacters() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");
        assertFalse(result.isEmpty());
        result.forEach(characterDTO -> assertTrue(characterDTO.getName().toUpperCase().contains("LUKE")));
    }

    @Test
    public void findAllByNameContains_ReturnsEmptyListWhenNoMatch() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("NonExistentCharacter");
        assertTrue(result.isEmpty());
    }

    @Test
    public void findAllByNameContains_IgnoresCase() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("luke");
        assertFalse(result.isEmpty());
        result.forEach(characterDTO -> assertTrue(characterDTO.getName().toUpperCase().contains("LUKE")));
    }
}