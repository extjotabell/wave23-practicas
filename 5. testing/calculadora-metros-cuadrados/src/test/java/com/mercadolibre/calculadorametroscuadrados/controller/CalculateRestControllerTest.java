package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateRestControllerTest {
    CalculateRestController controller = new CalculateRestController();


    @DisplayName("Test del controller")
    @Test
    public void calculate(){
        //ARRANGE
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTOS.add(new RoomDTO("cocina",10,10));
        HouseDTO houseDTO = new HouseDTO("casa1","av mira mar",roomDTOS);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(80000);
        expected.setBiggest(new RoomDTO("cocina",10,10));
        expected.setSquareFeet(100);

        //ACT

        HouseResponseDTO obtain = controller.calculate(houseDTO);

        //ASSERT

        assertEquals(expected,obtain);
    }
}
