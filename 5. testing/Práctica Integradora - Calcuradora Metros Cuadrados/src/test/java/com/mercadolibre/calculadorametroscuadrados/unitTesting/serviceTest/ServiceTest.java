package com.mercadolibre.calculadorametroscuadrados.unitTesting.serviceTest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    CalculateService service = new CalculateService();

    @Test
    @DisplayName("Test: calculate SquareFeet")
    void calculate(){
        RoomDTO roomDTO1 = new RoomDTO("Living", 30, 10);
        RoomDTO roomDTO2 = new RoomDTO("Habitación", 3, 5);
        RoomDTO roomDTO3 = new RoomDTO("Cocina", 10, 6);
        HouseDTO houseDTO = new HouseDTO("Casa1", "234", List.of(roomDTO1, roomDTO2, roomDTO3));
        HouseDTO payload = houseDTO;
        HouseResponseDTO responseExpected = new HouseResponseDTO(houseDTO);
        responseExpected.setBiggest(roomDTO1);
        responseExpected.setPrice(300000);
        responseExpected.setSquareFeet(375);
        HouseResponseDTO responseActual = service.calculate(houseDTO);

        Assertions.assertEquals(responseExpected.getSquareFeet(), responseActual.getSquareFeet());
    }

    @Test
    @DisplayName("Test: calculate price")
    void calculate2(){
        RoomDTO roomDTO = new RoomDTO("Living", 30, 10);
        HouseDTO houseDTO = new HouseDTO("Casa1", "234", List.of(roomDTO));
        HouseResponseDTO responseExpected = new HouseResponseDTO();
        responseExpected.setPrice(800 * 300);
        HouseResponseDTO responseActual = service.calculate(houseDTO);

        Assertions.assertEquals(responseExpected.getPrice(), responseActual.getPrice());
    }
}
