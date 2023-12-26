package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.HouseDTOTestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculateServiceTest {

    @Autowired
    private CalculateService calculateService;

    @Test
    @DisplayName("Calculate price  - House with rooms")
    void calculatePriceShouldReturnPrice(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithRooms();
        Integer expectedPrice = houseResponseDTO.getPrice();

        //Act
        Integer priceResult = calculateService.calculate(houseDTOTest).getPrice();

        //Assert
        assertEquals(expectedPrice, priceResult);
    }

    @Test
    @DisplayName("Get biggest room  - House with rooms")
    void obtainBiggestRoomShouldReturnBiggestRoom(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithRooms();
        RoomDTO biggestRoomExpected = houseResponseDTO.getBiggest();

        //Act
        RoomDTO roomResult = calculateService.calculate(houseDTOTest).getBiggest();

        //Assert
        assertEquals(biggestRoomExpected, roomResult);
    }

    @Test
    @DisplayName("Get square feet - House with rooms")
    void calculateSquareFeetShouldReturnSquareFeet(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithRooms();
        Integer squareFeetExpected = houseResponseDTO.getSquareFeet();

        //Act
        Integer squareFeetResult = calculateService.calculate(houseDTOTest).getSquareFeet();

        //Assert
        assertEquals(squareFeetExpected, squareFeetResult);
    }

    @Test
    @DisplayName("Calculate price  - House without rooms")
    void calculatePriceWithoutRoomsShouldReturnPriceZero(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithoutRooms();
        Integer expectedPrice = 0;

        //Act
        Integer price = calculateService.calculate(houseDTOTest).getPrice();

        //Assert
        assertEquals(expectedPrice, price);
    }

    @Test
    @DisplayName("Get square feet - House without rooms")
    void calculateSquareFeetShouldReturnZero(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithoutRooms();
        Integer expectedSquareFeet = 0;

        //Act
        Integer squareFeetResult = calculateService.calculate(houseDTOTest).getPrice();

        //Assert
        assertEquals(expectedSquareFeet, squareFeetResult);
    }

    @Test
    @DisplayName("Get biggest room  - House without rooms")
    void obtainBiggestRoomShouldReturnNull(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithoutRooms();
        RoomDTO expectedRoom = houseResponseDTO.getBiggest();

        //Act
        RoomDTO roomResult = calculateService.calculate(houseDTOTest).getBiggest();

        //Assert
        assertEquals(expectedRoom, roomResult);
    }




}
