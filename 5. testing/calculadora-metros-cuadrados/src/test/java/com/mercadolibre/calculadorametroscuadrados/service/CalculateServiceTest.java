package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.Builder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculateServiceTest {
    @Autowired
    CalculateService service;

    @Test
    @DisplayName("Test calculate and check correct price successfully")
    void calculateCheckPrice() {
        HouseDTO param = Builder.buildHouseDTO();
        Integer expectedResult = 160000;

        Integer result = service.calculate(param).getPrice();
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test calculate and check correct biggest room successfully")
    void calculateCheckBiggestRoom() {
        HouseDTO param = Builder.buildHouseDTO();
        RoomDTO expectedResult = Builder.buildRoomDTO();

        RoomDTO result = service.calculate(param).getBiggest();

        assertEquals(expectedResult.getName(), result.getName());
        assertEquals(expectedResult.getLength(), result.getLength());
        assertEquals(expectedResult.getWidth(), result.getWidth());
    }

    @Test
    @DisplayName("Test calculate and check correct price successfully")
    void calculateCheckSquareFeet() {
        HouseDTO param = Builder.buildHouseDTO();
        Integer expectedResult = 200;

        Integer result = service.calculate(param).getSquareFeet();
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test calculate with null value")
    void calculateWithNullValue() {
        HouseDTO param = null;

        assertThrows(NullPointerException.class,
                () -> service.calculate(param));
    }
}