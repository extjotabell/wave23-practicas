package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.atLeastOnce;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService service;
    @InjectMocks
    CalculateRestController controller;

    @Test
    @DisplayName("Test calculate successfully")
    void testCalculateOk() {
        HouseDTO param = Builder.buildHouseDTO();
        HouseResponseDTO expectedResult = Builder.buildResponseDTO(param);

        when(service.calculate(param)).thenReturn(expectedResult);
        HouseResponseDTO result = service.calculate(param);

        verify(service, atLeastOnce()).calculate(param);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test calculate with null request")
    void testCalculateWithNullRequest() {
        HouseDTO param = null;

        assertThrows(NullPointerException.class,
                () -> controller.calculate(param));
    }
}