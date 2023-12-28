package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl characterRepository = new CharacterRepositoryImpl();

    @Test
    void findAllByNameContainsNotNullTest(){
        String param = "Luke";
        Assertions.assertNotNull(characterRepository.findAllByNameContains(param));
    }

    @Test
    void findAllByNameContainsTest(){
        String param = "Luke";
        Assertions.assertEquals(createListCharacterDTO(), characterRepository.findAllByNameContains(param));
    }

    public List<CharacterDTO> createListCharacterDTO(){
        return new ArrayList<>(List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77)
        ));
    }

}
