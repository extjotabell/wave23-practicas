package com.mercadolibre.calculadorametroscuadrados.unitest;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.houseDto;
import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.roomDto1;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    private HouseDTO dto;

    @BeforeEach
    public void setup() {
        dto = houseDto();
    }

    @Test
    @DisplayName("calculate happy path")
    void calculateTest() {
        HouseResponseDTO expected = new HouseResponseDTO(dto);

        expected.setBiggest(roomDto1());
        expected.setSquareFeet(375);
        expected.setPrice(300000);

        when(service.calculate(dto)).thenReturn(expected);

        HouseResponseDTO actual = controller.calculate(dto);

        Assertions.assertEquals(expected.getBiggest(), actual.getBiggest());
        Assertions.assertEquals(expected.getSquareFeet(), actual.getSquareFeet());
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
    }
}
