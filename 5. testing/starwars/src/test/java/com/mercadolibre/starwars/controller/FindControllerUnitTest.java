package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindControllerUnitTest {

    @Mock
    FindService findService;

    @InjectMocks
    FindController findController;

    @Test
    void findTest(){

        String param = "Luke";

        List<CharacterDTO> characters;
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("starwars_characters.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            characters = objectMapper.readValue(inputStream, new TypeReference<List<CharacterDTO>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        when(findService.find(param)).thenReturn(characters);

        List<CharacterDTO> obtained = findController.find(param);

        Assertions.assertEquals(characters, obtained);

    }


}
