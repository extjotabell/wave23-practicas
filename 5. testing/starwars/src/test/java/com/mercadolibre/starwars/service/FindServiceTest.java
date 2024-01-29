package com.mercadolibre.starwars.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void findByNameLikeLuke() {
        List<CharacterDTO> charactersLikeLuke = new ArrayList<CharacterDTO>();
        CharacterDTO luke = new CharacterDTO();
        luke.setName("Luke Skywalker");
        luke.setHeight(172);
        luke.setMass(77);
        luke.setHair_color("blond");
        luke.setSkin_color("fair");
        luke.setEye_color("blue");
        luke.setBirth_year("19BBY");
        luke.setGender("male");
        luke.setHomeworld("Tatooine");
        luke.setSpecies("Human");
        charactersLikeLuke.add(luke);
        when(repository.findAllByNameContains("Luke")).thenReturn(charactersLikeLuke);

        List<CharacterDTO> characters = service.find("Luke");

        verify(repository, atLeastOnce()).findAllByNameContains("Luke");
        assertEquals(1, characters.size());
    }

    @Test
    void noCharactersFound() {
        when(repository.findAllByNameContains("LUKESSS")).thenReturn(new ArrayList<CharacterDTO>());

        List<CharacterDTO> characters = service.find("LUKESSS");

        verify(repository, atLeastOnce()).findAllByNameContains("LUKESSS");

        assertEquals(0, characters.size());
    }
}