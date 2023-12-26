package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculateServiceTest {
    CalculateService calculateService = new CalculateService();

    @DisplayName("Test de calcular")
    @Test
    public void calculatePrice(){
        //ARRANGE
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTOS.add(new RoomDTO("cocina",10,10));
        HouseDTO houseDTO = new HouseDTO("casa1","av mira mar",roomDTOS);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(80000);
        expected.setBiggest(new RoomDTO("cocina",10,10));
        expected.setSquareFeet(100);

        //ACT
        HouseResponseDTO obtain = calculateService.calculate(houseDTO);

        //ASSERT
        assertEquals(expected,obtain);
    }
}
