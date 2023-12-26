package com.mercadolibre.calculadorametroscuadrados.unitTest.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculateServiceTest {

    @Test
    void calculateOk(){
        //Arr
        HouseDTO expected = new HouseDTO("Mi casa","Calle 123", List.of(
                new RoomDTO("Cocina",5,7),
                new RoomDTO("Dormitorio",4,6),
                new RoomDTO("Lavanderia",6,8)
        ));
        CalculateService service = new CalculateService();

        //Act
        HouseResponseDTO result = service.calculate(expected);
        //Assert
        assertEquals(107,result.getSquareFeet());
        assertNotNull(result.getBiggest());
        assertEquals("Lavanderia", result.getBiggest().getName());
        assertEquals(85600, result.getPrice());
    }
    @Test
    void calculateNoRooms() {
        // Arrange
        HouseDTO expected = new HouseDTO("Casa vacia", "Calle 123", Collections.emptyList());
        CalculateService service = new CalculateService();

        // Act
        HouseResponseDTO result = service.calculate(expected);

        // Assert
        assertEquals(0, result.getSquareFeet());
        assertNull(result.getBiggest());
        assertEquals(0, result.getPrice());
    }

}
