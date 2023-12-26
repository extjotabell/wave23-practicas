package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.UtilsTest.getHouseDTO;
import static com.mercadolibre.calculadorametroscuadrados.util.UtilsTest.getRoomDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTest {

    CalculateService calculateService = new CalculateService();

    @Test
    @DisplayName("Calculate price of property")
    void test1() {
        // Arrange
        RoomDTO roomDTO = getRoomDTO("Normal", 12, 10);
        HouseDTO houseDTO = getHouseDTO("Mansion", "Calle falsa 123", List.of(roomDTO));
        Integer expectedPrice = 96000; // width(12) * length(10) of room * 800

        // Act
        HouseResponseDTO returnResponseDTO = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(expectedPrice, returnResponseDTO.getPrice());
    }

    @Test
    @DisplayName("Calculate square meter of property")
    void test2() {
        // Arrange
        RoomDTO roomDTO = getRoomDTO("Normal", 12, 10);
        HouseDTO houseDTO = getHouseDTO("Mansion", "Calle falsa 123", List.of(roomDTO));
        Integer expectedSquareFeet = 120; // width(12) * length(10) of room

        // Act
        HouseResponseDTO returnResponseDTO = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(expectedSquareFeet, returnResponseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("Calculate biggest room of property")
    void test3() {
        // Arrange
        RoomDTO roomInvites = getRoomDTO("Invites", 5, 5);
        RoomDTO roomBiggest = getRoomDTO("Suite", 12, 10);
        HouseDTO houseDTO = getHouseDTO("Mansion", "Calle falsa 123", List.of(roomInvites, roomBiggest));

        // Act
        HouseResponseDTO returnResponseDTO = calculateService.calculate(houseDTO);

        // Assert
        assertEquals(returnResponseDTO.getBiggest(), roomBiggest);
    }
}
