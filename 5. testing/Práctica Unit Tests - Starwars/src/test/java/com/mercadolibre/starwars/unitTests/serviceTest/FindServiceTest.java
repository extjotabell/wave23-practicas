package com.mercadolibre.starwars.unitTests.serviceTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    @DisplayName("Test para el método: find")
    void findTest(){
        //Arrange
        List<CharacterDTO> expectedCharacters = createCharacterList();
        //Act
        when(characterRepository.findAllByNameContains(any())).thenReturn(expectedCharacters);
        List<CharacterDTO> currentCharacters = findService.find(any());
        //Assert
        verify(characterRepository, atLeastOnce()).findAllByNameContains(any());
        assertEquals(expectedCharacters,currentCharacters);
    }

    private List<CharacterDTO> createCharacterList() {
        return List.of(
                new CharacterDTO("Luke Skywalker")
        );
    }

}
