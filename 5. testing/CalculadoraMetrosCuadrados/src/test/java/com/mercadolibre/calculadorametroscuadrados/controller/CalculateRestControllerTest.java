package com.mercadolibre.calculadorametroscuadrados.controller;


import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    private CalculateService calculateService;

    @InjectMocks
    private CalculateRestController controller;

    @Test
    @DisplayName("Test controller method calculate")
    void case1(){
        RoomDTO roomDTO1 = new RoomDTO("Living", 30, 10);
        RoomDTO roomDTO2 = new RoomDTO("Habitación", 3, 5);
        RoomDTO roomDTO3 = new RoomDTO("Cocina", 10, 6);
        HouseDTO houseDTO = new HouseDTO("Casa1", "234", List.of(roomDTO1, roomDTO2, roomDTO3));
        HouseResponseDTO responseExpected = new HouseResponseDTO(houseDTO);
        responseExpected.setBiggest(roomDTO1);
        responseExpected.setPrice(300000);
        responseExpected.setSquareFeet(375);

        //when(calculateService.calculate(any())).thenReturn(responseExpected);
        HouseResponseDTO responseActual = controller.calculate(houseDTO);

        Assertions.assertEquals(responseExpected, responseActual);

    }
}