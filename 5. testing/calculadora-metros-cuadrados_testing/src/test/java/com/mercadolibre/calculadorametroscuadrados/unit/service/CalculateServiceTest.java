package com.mercadolibre.calculadorametroscuadrados.unit.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateServiceTest {

    CalculateService service = new CalculateService();
    RoomDTO room, room_2, room_3;
    HouseDTO house;

    @BeforeEach
    void setUp(){
        room = new RoomDTO("Living", 30, 10);
        room_2 = new RoomDTO("Habitacion", 3, 5);
        room_3 = new RoomDTO("Cocina", 10, 6);
        house = new HouseDTO("Casa", "1234", List.of(room, room_2, room_3));
    }

    @Test
    @DisplayName("Test Calculate - SquareFeet")
    void calculateTest_SquareFeet(){
        HouseResponseDTO expected = new HouseResponseDTO(house);
        expected.setSquareFeet(375);

        HouseResponseDTO actual = service.calculate(house);

        assertEquals(expected.getSquareFeet(), actual.getSquareFeet());
    }

    @Test
    @DisplayName("Test Calculate - Price")
    void calculateTest_Price(){
        HouseResponseDTO expected = new HouseResponseDTO(house);
        expected.setPrice(300000);

        HouseResponseDTO actual = service.calculate(house);

        assertEquals(expected.getPrice(), actual.getPrice());
    }

}
