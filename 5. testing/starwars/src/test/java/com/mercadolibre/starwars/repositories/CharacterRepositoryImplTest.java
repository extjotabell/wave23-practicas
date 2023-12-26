package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharacterRepositoryImplTest {

    @Test
    @DisplayName("Get all characters by name contains successfully")
    void findAllByNameContainsTest() {
        // Arrange | Given
        // Create an instance of CharacterRepository to test
        CharacterRepositoryImpl repo = new CharacterRepositoryImpl();
        // Create a set of expected students for testing purposes
        List<CharacterDTO> expectedResult = createNewCharacterLukeDTO();

        // Act | When
        // Call the findAllByNameContains method of the repository
        List<CharacterDTO> result = repo.findAllByNameContains("Luke Skywalker");

        // Assert | Then
        // Check that the result is not null
        // Check that the size of the result is equal to the size of the expected set
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(expectedResult.size(), result.size())
        );
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