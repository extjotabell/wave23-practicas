package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Use MockitoExtension for JUnit 5
@ExtendWith(MockitoExtension.class)
class FindControllerTest {

    // Mock the FindService
    @Mock
    FindService service;

    // Inject mocks into the FindController
    @InjectMocks
    FindController controller;

    // Set up mocks before each test method
    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test case for finding a character with success")
    void testFindCharacterSuccess() {
        // Arrange | Given
        List<CharacterDTO> expectedResult = createNewCharacterLukeDTO();
        // Mock the service to return the expected result when finding "Luke Skywalker"
        Mockito.when(service.find("Luke Skywalker")).thenReturn(expectedResult);

        // Act | When
        List<CharacterDTO> responseEntity = controller.find("Luke Skywalker");

        // Assert | Then
        // Verify that the expected result is returned
        assertEquals(expectedResult, responseEntity);
        // Verify that the service's find method is called once with the argument "Luke Skywalker"
        Mockito.verify(service, Mockito.times(1)).find("Luke Skywalker");
    }

    /**
     * Private method to create a list containing a new CharacterDTO for Luke Skywalker.
     *
     * @return a list containing a new CharacterDTO for Luke Skywalker
     */
    private List<CharacterDTO> createNewCharacterLukeDTO() {
        // Create a new CharacterDTO for Luke Skywalker
        CharacterDTO characterDTO = new CharacterDTO(
                "Luke Skywalker",
                "blond",
                "fair",
                "blue",
                "19BBY",
                "male",
                "Tatooine",
                "Human",
                172,
                77
        );

        // Create a list containing the new CharacterDTO
        List<CharacterDTO> responseDTO = new ArrayList<>();
        responseDTO.add(characterDTO);

        return responseDTO;
    }

}