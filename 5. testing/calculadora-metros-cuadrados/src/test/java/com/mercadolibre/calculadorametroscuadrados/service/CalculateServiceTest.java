package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    CalculateService calculateService;

    @BeforeEach
    private void setUp() {
        this.calculateService = new CalculateService();
    }

    @Test
    @DisplayName("Calculo del valor de una propiedad Ok")
    void calculateHousePriceTestOk() {
        //Arrange
        RoomDTO room = new RoomDTO("room1", 10, 10);
        List<RoomDTO> rooms = List.of(room);
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", rooms);
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(null, 80000, null);

        //Act
        HouseResponseDTO responseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponseDTO.getPrice(), responseDTO.getPrice());
    }

    @Test
    @DisplayName("Calculo de m2 de una propiedad Ok")
    void calculateHouseSquareFeetTestOk() {
        //Arrange
        RoomDTO room = new RoomDTO("room1", 10, 10);
        List<RoomDTO> rooms = List.of(room);
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", rooms);
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(100, null, null);

        //Act
        HouseResponseDTO responseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponseDTO.getSquareFeet(), responseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("Habitacion mas grande de una propiedad Ok")
    void calculateBiggestRoomTestOk() {
        //Arrange
        RoomDTO room1 = new RoomDTO("room1", 10, 10);
        RoomDTO room2 = new RoomDTO("room2", 15, 10);
        List<RoomDTO> rooms = List.of(room1, room2);
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", rooms);
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(null, null, room2);

        //Act
        HouseResponseDTO responseDTO = calculateService.calculate(houseDTO);

        //Assert
        assertEquals(expectedResponseDTO.getBiggest(), responseDTO.getBiggest());

    }
}
