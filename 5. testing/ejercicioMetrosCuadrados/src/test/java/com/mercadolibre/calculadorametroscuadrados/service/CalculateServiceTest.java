package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    @Test
    @DisplayName("Calculate price with valid values")
    void calculate() {
        HouseDTO param = new HouseDTO(
                "Nombre genérico",
                "Dirección genérica",
                List.of(
                        new RoomDTO("Living", 5, 7),
                        new RoomDTO("Cocina", 5, 2),
                        new RoomDTO("Cuarto", 4, 4)
                )
        );
        HouseResponseDTO expectedResult = new HouseResponseDTO(
            param,
            61,
            48800,
            new RoomDTO("Living", 5, 7)
        );

        HouseResponseDTO result = service.calculate(param);

        assertEquals(expectedResult.getSquareFeet(), result.getSquareFeet());
        assertEquals(expectedResult.getPrice(), result.getPrice());
        assertEquals(expectedResult.getBiggest().getName(), result.getBiggest().getName());
        assertEquals(expectedResult.getBiggest().getWidth(), result.getBiggest().getWidth());
        assertEquals(expectedResult.getBiggest().getLength(), result.getBiggest().getLength());
    }
}