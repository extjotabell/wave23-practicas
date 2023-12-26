package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    public void findTest() throws JsonProcessingException {
        //ARRANGE
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));
        String param = "Luke";
        List<CharacterDTO> expected = characterDTOList;
        //ACT
        Mockito.when(findService.find(param)).thenReturn(characterDTOList);

        List<CharacterDTO> obtain = findController.find(param);

        //ASSERT
        Assertions.assertEquals(expected,obtain);
    }
}
