package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

// Use MockitoExtension for JUnit 5
@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    // Mock the CharacterRepository
    @Mock
    CharacterRepositoryImpl repository;

    // Inject mocks into the FindService
    @InjectMocks
    FindService service;

    // Set up mocks before each test method
    @BeforeEach
    void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Test case for finding a character with success")
    void findCharacterOk() {
        // Mock the behavior of repository.findAllByNameContains
        when(repository.findAllByNameContains("Luke Skywalker")).thenReturn(createNewCharacterLukeDTO());

        // Expected result
        List<CharacterDTO> expectedResult = createNewCharacterLukeDTO();

        // Actual result from the service
        List<CharacterDTO> result = service.find("Luke Skywalker");

        // Assert the results
        assertNotNull(result);
        assertEquals(expectedResult.size(), result.size());
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