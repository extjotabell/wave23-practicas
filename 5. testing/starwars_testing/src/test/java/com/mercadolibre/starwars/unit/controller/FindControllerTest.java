package com.mercadolibre.starwars.unit.controller;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTest {

    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    @DisplayName("Test Find - OK")
    void testFind_OK(){
        String query = "Luke";
        List<CharacterDTO> expected = List.of(
                new CharacterDTO("Luke Skywalker")
        );

        when(service.find(anyString())).thenReturn(expected);

        List<CharacterDTO> actual = controller.find(query);
        verify(service, atLeastOnce()).find(anyString());
        assertEquals(expected, actual);    }

}
