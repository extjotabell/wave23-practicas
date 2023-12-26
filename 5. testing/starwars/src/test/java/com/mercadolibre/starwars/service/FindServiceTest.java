package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.utils.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {
    @Mock
    CharacterRepository repository;
    @InjectMocks
    FindService service;

    @Test
    @DisplayName("Test find with only one result")
    void testFindOnlyOneResult() {
        String param = "Luke";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(repository.findAllByNameContains(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = service.find(param);

        assertEquals(expectedResult, result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test find with multiple results")
    void testFindMultipleResults() {
        String param = "Darth";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(repository.findAllByNameContains(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = service.find(param);

        assertEquals(expectedResult, result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test find with no results")
    void testFindNoResults() {
        String param = "Test";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(repository.findAllByNameContains(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = service.find(param);

        assertEquals(expectedResult, result);
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("Test find with null value")
    void testFindNullValue() {
        String param = null;

        when(repository.findAllByNameContains(param)).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class,
                () -> service.find(param));
    }
}