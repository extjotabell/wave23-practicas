package com.mercadolibre.calculadorametroscuadrados.unitarios;



import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {

    @Mock
    private CalculateService service;

    @InjectMocks
    private CalculateRestController controller;

    @Test
    @DisplayName("calculateControllerTest")
    public void calculate(){
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTOS.add(new RoomDTO("comedor",10,10));
        HouseDTO houseDTO = new HouseDTO("casa","test",roomDTOS);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);

        HouseResponseDTO obtain = controller.calculate(houseDTO);

        assertEquals(expected,obtain);
    }
}
