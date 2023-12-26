package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.mercadolibre.calculadorametroscuadrados.util.HouseDTODataTestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateServiceTests {
    private CalculateService calculateService;
    private HouseDTODataTestBuilder houseDTODataTestBuilder;

    @BeforeEach
    public void setup() {
        calculateService = new CalculateService();
        houseDTODataTestBuilder = new HouseDTODataTestBuilder();
    }

    @Test
    @DisplayName("Calculates total square feet and price for house with rooms of same size")
    void calculatesTotalSquareFeetAndPriceForHouseWithRoomsOfSameSize() {
        HouseDTO house = new HouseDTODataTestBuilder().createByDefaultWithoutRooms().withRoom("Room1", 10, 10).withRoom("Room2", 10, 10).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(200, response.getSquareFeet());
        assertEquals(160000, response.getPrice());
    }

    @Test
    @DisplayName("Identifies biggest room in house with rooms of same size")
    void identifiesBiggestRoomInHouseWithRoomsOfSameSize() {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1", 10, 10).withRoom("Room2", 10, 10).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(100, response.getBiggest().getSquareFeet());
    }

    @Test
    @DisplayName("Calculates total square feet and price for house with room of zero size")
    void calculatesTotalSquareFeetAndPriceForHouseWithRoomOfZeroSize() {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1", 0, 0).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(0, response.getSquareFeet());
        assertEquals(0, response.getPrice());
    }

    @Test
    @DisplayName("Identifies biggest room in house with room of zero size")
    void identifiesBiggestRoomInHouseWithRoomOfZeroSize() {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1", 0, 0).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals(0, response.getBiggest().getSquareFeet());
    }

    @Test
    @DisplayName("Identifies largest room based on dimensions not on area")
    void identifiesLargestRoomBasedOnDimensionsNotOnArea() {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1", 10, 20).withRoom("Room2", 20, 10).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals("Room1", response.getBiggest().getName());
    }

    @Test
    @DisplayName("Identifies largest room with a big room and a small room")
    void identifiesLargestRoomWithABigRoomAndASmallRoom() {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1", 10, 10).withRoom("Room2", 20, 20).build();
        HouseResponseDTO response = calculateService.calculate(house);
        assertEquals("Room2", response.getBiggest().getName());
    }
}
