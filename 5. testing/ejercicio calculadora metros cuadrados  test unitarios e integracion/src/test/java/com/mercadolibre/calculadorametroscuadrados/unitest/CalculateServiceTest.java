package com.mercadolibre.calculadorametroscuadrados.unitest;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.houseDto;
import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.roomDto1;

@SpringBootTest
class CalculateServiceTest {

    @Autowired
    CalculateService service;

    private HouseDTO houseDto;

    @BeforeEach
    public void setup() {
        houseDto = houseDto();
    }

    @Test
    @DisplayName("calculate happy path")
    void calculateTest() {
        HouseResponseDTO expected = new HouseResponseDTO(houseDto);

        expected.setBiggest(roomDto1());
        expected.setSquareFeet(375);
        expected.setPrice(300000);

        HouseResponseDTO actual = service.calculate(houseDto);

        Assertions.assertEquals(expected.getBiggest().getName(), actual.getBiggest().getName());
        Assertions.assertEquals(expected.getSquareFeet(), actual.getSquareFeet());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
    }

}
