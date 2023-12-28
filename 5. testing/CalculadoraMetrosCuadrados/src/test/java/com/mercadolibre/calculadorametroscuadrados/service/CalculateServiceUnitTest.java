package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.FactoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateServiceUnitTest {

    CalculateService calculateService = new CalculateService();

    @Test
    void calculateTest(){
        HouseDTO param = FactoryDTO.factoryHouseDTO();

        HouseResponseDTO response = calculateService.calculate(param);

        HouseResponseDTO evaluate = FactoryDTO.factoryHouseResponseDTO(param, 950,
                760000, FactoryDTO.factoryRoomDTO("Room 1", 10, 50));

        Assertions.assertEquals(evaluate, response);
    }

}
