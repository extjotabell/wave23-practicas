package com.mercadolibre.starwars.controller;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.service.FindService;
import com.mercadolibre.starwars.utils.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindControllerTest {
    @Mock
    FindService service;
    @InjectMocks
    FindController controller;

    @Test
    @DisplayName("Test find with only one result")
    void testFindOnlyOneResult() {
        String param = "Luke";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(1, result.size());
    }

    @Test
    @DisplayName("Test find with multiple results")
    void testFindMultipleResults() {
        String param = "Darth";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(2, result.size());
    }

    @Test
    @DisplayName("Test find with no result")
    void testFindNoResults() {
        String param = "Test";
        List<CharacterDTO> expectedResult = Builder.buildCharacterLists(param);

        when(service.find(param)).thenReturn(expectedResult);
        List<CharacterDTO> result = controller.find(param);

        assertEquals(expectedResult, result);
        assertEquals(0, result.size());
    }
}