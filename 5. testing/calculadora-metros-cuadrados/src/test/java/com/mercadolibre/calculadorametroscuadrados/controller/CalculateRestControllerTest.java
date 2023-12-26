package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    @DisplayName("Calcular desde controller")
    void calculate() {
        // Arrange
        HouseResponseDTO expectdeResponseDTO = new HouseResponseDTO();

        // Act
        when(calculateService.calculate(any())).thenReturn(expectdeResponseDTO);
        HouseResponseDTO responseHouseDTO = this.calculateRestController.calculate(any());

        // Assert
        verify(calculateService, atLeastOnce()).calculate(any());
        assertEquals(expectdeResponseDTO, responseHouseDTO);
    }
}
