package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.TestDtoGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {
    HouseDTO newHouseDto;
    HouseResponseDTO actualResponse;
    CalculateService calculateService = new CalculateService();

    @BeforeEach
    public void config(){
        newHouseDto = TestDtoGenerator.newHouseDto();
        actualResponse = calculateService.calculate(newHouseDto);
    }

    @Test
    void calculateSquareFeetTest(){
        assertEquals(TestDtoGenerator.responseSquaredFeet(), actualResponse.getSquareFeet());
    }

    @Test
    void showHouseDataTest(){
        assertEquals(TestDtoGenerator.newHouseDto().getName(), actualResponse.getName());
        assertEquals(TestDtoGenerator.newHouseDto().getAddress(), actualResponse.getAddress());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(0).getName(), actualResponse.getRooms().get(0).getName());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(0).getWidth(), actualResponse.getRooms().get(0).getWidth());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(0).getLength(), actualResponse.getRooms().get(0).getLength());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(1).getName(), actualResponse.getRooms().get(1).getName());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(1).getWidth(), actualResponse.getRooms().get(1).getWidth());
        assertEquals(TestDtoGenerator.newHouseDto().getRooms().get(1).getLength(), actualResponse.getRooms().get(1).getLength());
    }

    @Test
    void calculatePriceTest(){
        assertEquals(TestDtoGenerator.responsePrice(), actualResponse.getPrice());
    }

    @Test
    void calculateBiggestRoom(){
        assertEquals(TestDtoGenerator.responseBiggestRoom().getName(), actualResponse.getBiggest().getName());
        assertEquals(TestDtoGenerator.responseBiggestRoom().getLength(), actualResponse.getBiggest().getLength());
        assertEquals(TestDtoGenerator.responseBiggestRoom().getWidth(), actualResponse.getBiggest().getWidth());
    }
}
