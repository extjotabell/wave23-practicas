package com.mercadolibre.starwars.unit.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CharacterRepositoryTest {

    @Autowired
    CharacterRepositoryImpl repository;

    @Test
    @DisplayName("Test FindAllByNameContains - OK")
    void testFindAllByNameContains(){
        String query = "Luke";

        List<CharacterDTO> actual = repository.findAllByNameContains(query);

        assertEquals(1, actual.size());
    }

}
