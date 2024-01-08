package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculateControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

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
    @DisplayName("Test Calculate")
    void testCalculate(){
        HouseResponseDTO expected = new HouseResponseDTO(house);
        expected.setBiggest(room);
        expected.setPrice(300000);
        expected.setSquareFeet(375);

        when(service.calculate(any())).thenReturn(expected);

        HouseResponseDTO actual = controller.calculate(house);

        assertEquals(expected, actual);
    }
}
