package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @DisplayName("Test del controller")
    @Test
    public void find(){
        //ARRANGE
        String param = "Luke";
        List<CharacterDTO> test_list = new ArrayList<>();
        test_list.add(new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));

        //ACT
        Mockito.when(findService.find(param)).thenReturn(test_list);

        List<CharacterDTO> obtain = findController.find(param);

        //ASSERT

        assertEquals(test_list,obtain);
    }
}
