package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculateServiceWithoutMockTest {

    @Test
    @DisplayName("Test to verify the right calculation of the value of a house")
    void testCalculateMethod() {
        //Arrange
        CalculateService calculateService = new CalculateService();
        RoomDTO room1House1 = new RoomDTO();
        room1House1.setName("Room1 of House 1");
        room1House1.setWidth(5);
        room1House1.setLength(5);

        RoomDTO room2House1 = new RoomDTO();
        room2House1.setName("Room2 of House 1");
        room2House1.setWidth(8);
        room2House1.setLength(10);

        HouseDTO house1 = new HouseDTO();
        house1.setName("House1");
        house1.setAddress("Address1");
        house1.setRooms(Arrays.asList(room1House1, room2House1));

        Integer expectedPrice1 = 84000;

        //Act
        HouseResponseDTO result1 = calculateService.calculate(house1);

        //Assert
        assertEquals(expectedPrice1, result1.getPrice());
    }

    @Test
    @DisplayName("Test to verify the room with greatest dimension is considered the biggest room")
    void testRoomDimensionMethod() {
        //Arrange
        CalculateService calculateService = new CalculateService();
        RoomDTO room1House1 = new RoomDTO();
        room1House1.setName("Room1 of House 1");
        room1House1.setWidth(5);
        room1House1.setLength(5);

        RoomDTO room2House1 = new RoomDTO();
        room2House1.setName("Room2 of House 1");
        room2House1.setWidth(8);
        room2House1.setLength(10);

        HouseDTO house1 = new HouseDTO();
        house1.setName("House1");
        house1.setAddress("Address1");
        house1.setRooms(Arrays.asList(room1House1, room2House1));

        RoomDTO expectedBiggestRoom = room2House1;

        //Act
        HouseResponseDTO result1 = calculateService.calculate(house1);

        //Assert
        assertEquals(expectedBiggestRoom, result1.getBiggest());
    }

    @Test
    @DisplayName("Test to verify the right return of square fett per room")
    void testSquareFeetPerRoomMethod() {
        //Arrange
        CalculateService calculateService = new CalculateService();
        RoomDTO room1House1 = new RoomDTO();
        room1House1.setName("Room1 of House 1");
        room1House1.setWidth(5);
        room1House1.setLength(5);

        RoomDTO room2House1 = new RoomDTO();
        room2House1.setName("Room2 of House 1");
        room2House1.setWidth(8);
        room2House1.setLength(10);

        HouseDTO house1 = new HouseDTO();
        house1.setName("House1");
        house1.setAddress("Address1");
        house1.setRooms(Arrays.asList(room1House1, room2House1));

        Integer expectedSquareFeet1 = 25;
        Integer expectedSquareFeet2 = 80;

        //Act
        HouseResponseDTO result1 = calculateService.calculate(house1);

        //Assert
        assertEquals(expectedSquareFeet1, result1.getRooms().get(0).getSquareFeet());
        assertEquals(expectedSquareFeet2, result1.getRooms().get(1).getSquareFeet());
    }
}
