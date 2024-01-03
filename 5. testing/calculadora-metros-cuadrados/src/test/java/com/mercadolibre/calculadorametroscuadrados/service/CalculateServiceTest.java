package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculateServiceTest {
    private HouseDTO house;

    @BeforeEach
    void setUp() {
        house = new HouseDTO();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Room 1");
        room1.setLength(10);
        room1.setWidth(10);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Room 2");
        room2.setLength(5);
        room2.setWidth(5);
        RoomDTO room3 = new RoomDTO();
        room3.setName("Room 3");
        room3.setLength(10);
        room3.setWidth(5);

        house.setRooms(new ArrayList<RoomDTO>() {{
            add(room1);
            add(room2);
            add(room3);
        }});
    }

    @Test
    @DisplayName("Should calculate room square feet")
    void calculateRoomSquareFeet() {
        // act
        CalculateService calculateService = new CalculateService();
        calculateService.calculate(house);

        // assert
        assertEquals(100, house.getRooms().get(0).getSquareFeet());
        assertEquals(25, house.getRooms().get(1).getSquareFeet());
        assertEquals(50, house.getRooms().get(2).getSquareFeet());
    }

    @Test
    @DisplayName("Should calculate house square feet")
    void calculateHouseSquareFeet() {
        // act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // assert
        assertEquals(175, responseDTO.getSquareFeet());
    }

    @Test
    @DisplayName("Should calculate house price")
    void calculateHousePrice() {
        // act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // assert
        assertEquals(140000, responseDTO.getPrice());
    }

    @Test
    @DisplayName("Should calculate biggest room")
    void calculateBiggestRoom() {
        // act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // assert
        assertEquals("Room 1", responseDTO.getBiggest().getName());
    }

    @Test
    @DisplayName("Should calculate biggest room when there is more than one")
    void calculateBiggestRoomWhenThereIsMoreThanOne() {
        // arrange
        house.getRooms().get(0).setLength(10);
        house.getRooms().get(0).setWidth(10);
        house.getRooms().get(1).setLength(10);
        house.getRooms().get(1).setWidth(10);

        // act
        CalculateService calculateService = new CalculateService();
        HouseResponseDTO responseDTO = calculateService.calculate(house);

        // assert
        assertEquals("Room 1", responseDTO.getBiggest().getName());
    }
}
