package com.mercadolibre.starwars.controllerTest;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    //List<CharacterDTO>
    @Test
    public void find() {
        //Arrange
        String query = "Vader";

        List<CharacterDTO> characterDTOSResponse = List.of(
                new CharacterDTO("Darth Vader",
                        "none",
                        "white",
                        "yellow",
                        "41.9BBY",
                        "male",
                        "Tatooine",
                        "Human",
                        202,
                        136)
        );

        //Act
        Mockito.when(characterRepository.findAllByNameContains(query)).thenReturn(characterDTOSResponse);

        List<CharacterDTO> result = findService.find(query);

        //Assert

        Assertions.assertEquals(result, characterDTOSResponse);


    }
}
