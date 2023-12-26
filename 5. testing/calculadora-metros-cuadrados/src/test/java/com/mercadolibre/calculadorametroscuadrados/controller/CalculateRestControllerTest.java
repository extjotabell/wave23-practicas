package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.HouseDTOTestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController calculateRestController;

    @Test
    @DisplayName("House with rooms - obtain the calculated values")
    void calculateDataHouseDTOShouldReturnValidData(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTOExpected = HouseDTOTestGenerator.getHouseResponseDTOWithRooms();
        when(calculateService.calculate(houseDTOTest)).thenReturn(houseResponseDTOExpected);

        //Act
        HouseResponseDTO resultDTO = calculateRestController.calculate(houseDTOTest);

        //Assert
        assertEquals(houseResponseDTOExpected.getName(),resultDTO.getName());
        assertEquals(houseResponseDTOExpected.getRooms(),resultDTO.getRooms());
        assertEquals(houseResponseDTOExpected.getAddress(),resultDTO.getAddress());
        assertEquals(houseResponseDTOExpected.getBiggest(),resultDTO.getBiggest());
        assertEquals(houseResponseDTOExpected.getPrice(),resultDTO.getPrice());
    }

    @Test
    @DisplayName("House without rooms - obtain the calculated values(zero)")
    void calculateDataHouseDTOShouldReturnDataAndZero(){
        //Arrange
        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTOExpected = HouseDTOTestGenerator.getHouseResponseDTOWithoutRooms();
        when(calculateService.calculate(houseDTOTest)).thenReturn(houseResponseDTOExpected);

        //Act
        HouseResponseDTO resultDTO = calculateRestController.calculate(houseDTOTest);

        //Assert
        assertEquals(houseResponseDTOExpected.getName(),resultDTO.getName());
        assertEquals(houseResponseDTOExpected.getRooms(),resultDTO.getRooms());
        assertEquals(houseResponseDTOExpected.getAddress(),resultDTO.getAddress());
        assertEquals(houseResponseDTOExpected.getBiggest(),resultDTO.getBiggest());
        assertEquals(houseResponseDTOExpected.getPrice(),resultDTO.getPrice());
    }
}
