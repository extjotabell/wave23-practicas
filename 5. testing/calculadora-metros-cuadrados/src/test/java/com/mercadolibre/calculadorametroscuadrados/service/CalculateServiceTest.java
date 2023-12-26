package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.utils.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculateServiceTest {
    CalculateService service = new CalculateService();
    private HouseDTO houseDTO;

    @BeforeEach
    void initialize() {
        houseDTO = Builder.buildHouseDTO();
    }

    @Test
    @DisplayName("Test calculate and check correct price successfully")
    void calculateCheckPrice() {
        HouseDTO param = houseDTO;
        Integer expectedResult = 160000;

        Integer result = service.calculate(param).getPrice();
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test calculate and check correct biggest room successfully")
    void calculateCheckBiggestRoom() {
        HouseDTO param = houseDTO;
        RoomDTO expectedResult = new RoomDTO();
        expectedResult.setName("Living Room");
        expectedResult.setWidth(10);
        expectedResult.setLength(12);

        RoomDTO result = service.calculate(param).getBiggest();
        assertEquals(expectedResult.getName(), result.getName());
        assertEquals(expectedResult.getLength(), result.getLength());
        assertEquals(expectedResult.getWidth(), result.getWidth());
    }

    @Test
    @DisplayName("Test calculate and check correct price successfully")
    void calculateCheckSquareFeet() {
        HouseDTO param = houseDTO;
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