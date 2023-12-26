package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
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
public class FindServiceTest {
    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTest() throws JsonProcessingException {
        //ARRANGE
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));
        String param = "Luke";

        //ACT
        String expected = writer.writeValueAsString(characterDTOList);

        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(characterDTOList);

        String obtain = writer.writeValueAsString(findService.find(param));

        //ASSERT
        Assertions.assertEquals(expected,obtain);

    }
}
