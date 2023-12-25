package com.mercadolibre.starwars.repositories;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

    @DisplayName("Test de encontrar al personaje por contains")
    @Test
    public void findAllByNameContains() throws JsonProcessingException {
        //ARRANGE
        List<CharacterDTO> test_list = new ArrayList<>();
        test_list.add(new CharacterDTO("Luke Skywalker","blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));
        String expected = writer.writeValueAsString(test_list);

        //ACT
        String obtain = writer.writeValueAsString(characterRepository.findAllByNameContains("Luke"));

        //ASSERT

        assertEquals(expected,obtain);
    }
}
