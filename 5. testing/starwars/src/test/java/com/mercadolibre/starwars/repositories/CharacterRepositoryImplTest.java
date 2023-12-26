package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.utils.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CharacterRepositoryImplTest {
    CharacterRepositoryImpl repository = new CharacterRepositoryImpl();

    @Test
    @DisplayName("Test findAllByNameContains with only one result")
    void testFindAllByNameContainsOnlyOneResult() {
        String param = "Luke";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with multiple results")
    void testFindAllByNameContainsMultipleResults() {
        String param = "Darth";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with no results")
    void testFindAllByNameContainsNoResults() {
        String param = "Test";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        List<CharacterDTO> result = repository.findAllByNameContains(param);

        assertEquals(expectedResult, result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test findAllByNameContains with null value")
    void testFindAllByNameContainsWithNullValue() {
        String param = null;

        assertThrows(NullPointerException.class,
                () -> repository.findAllByNameContains(param));
    }
}