package com.mercadolibre.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @DisplayName("Test del service")
    @Test
    public void find() throws JsonProcessingException {
        //ARRANGE
        String param = "luke";
        List<CharacterDTO> test_list = new ArrayList<>();
        test_list.add(new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));
        String expected = writer.writeValueAsString(test_list);

        //ACT

        Mockito.when(characterRepository.findAllByNameContains(param)).thenReturn(test_list);

        String obtain = writer.writeValueAsString(findService.find(param));

        //ASSERT

        assertEquals(expected,obtain);
    }
}
