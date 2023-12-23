package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository repository;

    @InjectMocks
    FindService service;

    @Test
    void findCaseOk(){
        //Arrange
        List<CharacterDTO> luke = List.of(
                new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77));
        String queryName = "Luke";
        when(repository.findAllByNameContains(queryName)).thenReturn(luke);
        //Act
        List<CharacterDTO> result = service.find(queryName);
        //Assert
        assertEquals(luke,result);
    }

    @Test
    void findCaseNonOk(){
        //Arrange
        List<CharacterDTO> emptyList = List.of();
        String queryName = "noexiste";
        when(repository.findAllByNameContains(queryName)).thenReturn(emptyList);
        //Act
        List<CharacterDTO> result = service.find(queryName);
        //Assert
        assertTrue(result.isEmpty());
    }
}
