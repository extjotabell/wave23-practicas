package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
class CalculateRestControllerTests {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @BeforeEach
    void setUp() { openMocks(this); }

    @Test
    @DisplayName("Calculate should return the correct response")
    void calculateOk() {
        // Arrange
        HouseDTO house = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        room1.setName("Habitacion 1");
        room1.setLength(10);
        room1.setWidth(10);

        room2.setName("Habitacion 2");
        room2.setLength(5);
        room2.setWidth(5);

        house.setRooms(Arrays.asList(room1, room2));

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);

        houseResponse.setSquareFeet(125);
        houseResponse.setPrice(100000);

        // Act
        when(calculateService.calculate(house)).thenReturn(new HouseResponseDTO(houseResponse));
        HouseResponseDTO response = calculateRestController.calculate(house);

        // Assert
        assertEquals(125, response.getSquareFeet());
        assertEquals(100000, response.getPrice());
    }

    @Test
    @DisplayName("Calculate with no rooms")
    void calculateWithNoRooms() {
        // Arrange
        HouseDTO house = new HouseDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        // Act & Assert
        when(calculateService.calculate(house)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> { calculateRestController.calculate(house); });
    }

    @Test
    @DisplayName("Calculate with rooms with no dimensions")
    void calculateWithRoomsWithNoDimensions() {
        // Arrange
        HouseDTO house = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        room1.setName("Habitacion 1");

        room2.setName("Habitacion 2");

        house.setRooms(Arrays.asList(room1, room2));

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);

        houseResponse.setSquareFeet(0);
        houseResponse.setPrice(0);

        // Act & Assert
        when(calculateService.calculate(house)).thenReturn(new HouseResponseDTO(houseResponse));

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(0, response.getSquareFeet());
        assertEquals(0, response.getPrice());
    }

    @Test
    @DisplayName("Get biggest room should return the correct response")
    void getBiggestRoomOk() {
        // Arrange
        HouseDTO house = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        room1.setName("Habitacion 1");
        room1.setLength(10);
        room1.setWidth(10);

        room2.setName("Habitacion 2");
        room2.setLength(5);
        room2.setWidth(5);

        house.setRooms(Arrays.asList(room1, room2));

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);

        houseResponse.setBiggest(room1);

        // Act
        when(calculateService.calculate(house)).thenReturn(new HouseResponseDTO(houseResponse));
        HouseResponseDTO response = calculateRestController.calculate(house);

        // Assert
        assertEquals(room1, response.getBiggest());
    }

    @Test
    @DisplayName("Get biggest room with no rooms")
    void getBiggestRoomWithNoRooms() {
        // Arrange
        HouseDTO house = new HouseDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        // Act & Assert
        when(calculateService.calculate(house)).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> { calculateRestController.calculate(house); });
    }

    @Test
    @DisplayName("Get biggest room with rooms with no dimensions")
    void getBiggestRoomWithRoomsWithNoDimensions() {
        // Arrange
        HouseDTO house = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        RoomDTO room2 = new RoomDTO();

        house.setName("Casa 1");
        house.setAddress("Calle 1");

        room1.setName("Habitacion 1");

        room2.setName("Habitacion 2");

        house.setRooms(Arrays.asList(room1, room2));

        HouseResponseDTO houseResponse = new HouseResponseDTO(house);

        houseResponse.setBiggest(room1);

        // Act & Assert
        when(calculateService.calculate(house)).thenReturn(new HouseResponseDTO(houseResponse));

        HouseResponseDTO response = calculateRestController.calculate(house);

        assertEquals(room1, response.getBiggest());
    }
}
