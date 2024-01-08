package com.mercadolibre.starwars.unit.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Test Find - OK")
    void testFind_OK(){
        String query = "Luke";
        List<CharacterDTO> expected = List.of(
                new CharacterDTO("Luke Skywalker")
        );

        when(repository.findAllByNameContains(anyString())).thenReturn(expected);

        List<CharacterDTO> actual = service.find(query);

        verify(repository, atLeastOnce()).findAllByNameContains(anyString());
        assertEquals(expected, actual);
    }

}
