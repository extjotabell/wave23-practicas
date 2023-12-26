package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CalculateServiceTests {

    CalculateService calculateService;

    @BeforeEach
    void setUp() { calculateService = new CalculateService(); }

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

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

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
        Assertions.assertThrows(NullPointerException.class, () -> {calculateService.calculate(house); });
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

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
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

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

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
        Assertions.assertThrows(NullPointerException.class, () -> {calculateService.calculate(house); });
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

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(room1.getLength(), response.getBiggest().getLength());
        assertEquals(room1.getWidth(), response.getBiggest().getWidth());
    }

    @Test
    @DisplayName("Get biggest room with rooms with the same dimensions")
    void getBiggestRoomWithRoomsWithSameDimensions() {
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
        room2.setLength(10);
        room2.setWidth(10);

        house.setRooms(Arrays.asList(room1, room2));

        // Act
        HouseResponseDTO response = calculateService.calculate(house);

        // Assert
        assertEquals(room1, response.getBiggest());
    }
}
