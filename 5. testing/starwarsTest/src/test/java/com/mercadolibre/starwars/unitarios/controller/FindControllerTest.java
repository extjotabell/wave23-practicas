package com.mercadolibre.starwars.unitarios.controller;


import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void findTestController() {
        String query = "Darth";
        CharacterDTO character = new CharacterDTO();
        character.setName("Darth Vader");
        List<CharacterDTO> expectedCharacters = Collections.singletonList(character);
        when(service.find(query)).thenReturn(expectedCharacters);

        List<CharacterDTO> actualCharacters = controller.find(query);

        assertEquals(expectedCharacters, actualCharacters);
        verify(service, times(1)).find(query);
    }

    @Test
    void findTestControllerEmptyList() {
        String query = "fweff";
        when(service.find(query)).thenReturn(Collections.emptyList());

        List<CharacterDTO> actualCharacters = controller.find(query);

        assertEquals(Collections.emptyList(), actualCharacters);
        verify(service, times(1)).find(query);
    }
}
