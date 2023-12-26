package com.mercadolibre.starwars.unitTests.controllerTest;

import com.mercadolibre.starwars.controller.FindController;
import com.mercadolibre.starwars.dto.CharacterDTO;
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
public class FindControllerTest {

    @Mock
    private FindService findService;

    @InjectMocks
    private FindController findController;

    @Test
    @DisplayName("Test para el método: find")
    void findTest(){
        //Arrange
        List<CharacterDTO> expectedCharacters = createCharacterList();
        //Act
        when(findService.find(any())).thenReturn(expectedCharacters);
        List<CharacterDTO> currentCharacter = findController.find("Skywalker");
        //Assert
        verify(findService, atLeastOnce()).find("Skywalker");
        assertEquals(expectedCharacters,currentCharacter);

    }

    private List<CharacterDTO> createCharacterList() {
        return List.of(
                new CharacterDTO("Luke Skywalker")
        );
    }

}
