package com.mercadolibre.starwars.unitarios.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CharacterRepositoryTest {

    @Autowired
    private CharacterRepositoryImpl characterRepository;

    @Test
    public void findAllByNameContainsTestOk() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("Luke");

        result.forEach(characterDTO -> assertTrue(characterDTO.getName().toUpperCase().contains("LUKE")));
    }

    @Test
    public void findAllByNameContainsTestEmptyList() {
        List<CharacterDTO> result = characterRepository.findAllByNameContains("cwdwde");
        assertTrue(result.isEmpty());
    }
}
