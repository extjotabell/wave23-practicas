package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    @BeforeEach
    private void setUp() {
        this.service = new CalculateService();
    }

    @Test
    void calculatetest(){

        HouseDTO houseDTO = createTestHouse();
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO();
        expectedResponseDTO.setPrice(24800);
        HouseResponseDTO responseDTO = service.calculate(houseDTO);
        assertEquals(expectedResponseDTO.getPrice(), responseDTO.getPrice());
    }

    private HouseDTO createTestHouse() {
        return new HouseDTO("Casa Diana", "CDMX", List.of(
                new RoomDTO("habitacion1", 5, 5),
                new RoomDTO("habitacion2", 3, 2)
        ));
    }

}
