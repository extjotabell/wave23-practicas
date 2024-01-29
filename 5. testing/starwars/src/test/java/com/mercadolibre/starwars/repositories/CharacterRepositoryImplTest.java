package com.mercadolibre.starwars.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mercadolibre.starwars.dto.CharacterDTO;

public class CharacterRepositoryImplTest {
    private CharacterRepository repository;

    @BeforeEach
    void initAll() {
        this.repository = new CharacterRepositoryImpl();
    }

    @Test
    void find1() {
        List<CharacterDTO> characters = this.repository.findAllByNameContains("Luke");
        assertEquals(1, characters.size());
        assertEquals("Luke Skywalker", characters.get(0).getName());
    }

    @Test
    void find2() {
        List<CharacterDTO> characters = this.repository.findAllByNameContains("Darth");
        assertEquals(2, characters.size());
        assertTrue(characters.stream().anyMatch(character -> character.getName().equalsIgnoreCase("Darth Vader")));
        assertTrue(characters.stream().anyMatch(character -> character.getName().equalsIgnoreCase("Darth Maul")));
    }

    @Test
    void noCharacterFound(){
        List<CharacterDTO> characters = this.repository.findAllByNameContains("Darthhh");
        assertEquals(0, characters.size());
    }
}