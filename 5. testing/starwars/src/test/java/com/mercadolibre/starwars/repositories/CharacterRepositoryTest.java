package com.mercadolibre.starwars.repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

    @Test
    public void findAllByNameContainsTest() throws JsonProcessingException {
        //ARRANGE
        List<CharacterDTO> characterDTOList = new ArrayList<>();
        characterDTOList.add(new CharacterDTO("blond","fair","blue",
                "19BBY","male","Tatooine","Human",172,77));

        //ACT
        List<CharacterDTO> obtainedCharacters = characterRepository.findAllByNameContains("Luke");

        // ASSERT
        Assertions.assertEquals(characterDTOList.size(), obtainedCharacters.size());
    }
}
