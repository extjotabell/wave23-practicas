package com.mercadolibre.calculadorametroscuadrados.unitarios;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {

    CalculateService service = new CalculateService();


    @Test
    @DisplayName("calculateRoomSquareFeet Service Test")
    void calculateRoomSquareFeet(){
        RoomDTO roomDTO1 = new RoomDTO("Comedor", 10, 10);
        RoomDTO roomDTO2 = new RoomDTO("Cocina", 5, 5);
        HouseDTO houseDTO = new HouseDTO("Casa", "test", List.of(roomDTO1, roomDTO2));

        HouseResponseDTO responseExpected = new HouseResponseDTO(houseDTO);
        responseExpected.setSquareFeet(125);

        HouseResponseDTO responseActual = service.calculate(houseDTO);

        assertEquals(responseExpected.getSquareFeet(), responseActual.getSquareFeet());
    }

    @Test
    @DisplayName("calculatePrice Service Test")
    void calculatePrice(){
        RoomDTO roomDTO1 = new RoomDTO("Comedor", 10, 10);
        RoomDTO roomDTO2 = new RoomDTO("Cocina", 5, 5);
        HouseDTO houseDTO = new HouseDTO("Casa", "test", List.of(roomDTO1, roomDTO2));

        HouseResponseDTO responseExpected = new HouseResponseDTO(houseDTO);
        responseExpected.setPrice(125 * 800);

        HouseResponseDTO responseActual = service.calculate(houseDTO);

        assertEquals(responseExpected.getPrice(), responseActual.getPrice());
    }

}
