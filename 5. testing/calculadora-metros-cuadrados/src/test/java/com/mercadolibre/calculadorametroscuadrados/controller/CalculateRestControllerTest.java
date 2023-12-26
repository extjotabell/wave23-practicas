package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.mercadolibre.calculadorametroscuadrados.util.ObjectFactory.getRoomsDto;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
    @InjectMocks
    CalculateRestController controller;

    @Test
    public void calculateTest(){
        HouseDTO houseDTO = getRoomsDto();
        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(8000);
        expected.setBiggest(new RoomDTO("cocina",5,2));
        expected.setSquareFeet(10);

        //ACT
        HouseResponseDTO obtain = controller.calculate(houseDTO);

        //ASSERT
        assertEquals(expected,obtain);

    }
}
