package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.ObjectFactory.getRoomsDto;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    CalculateService service;

    @Test
    public void calculateTest(){
        HouseDTO houseDTO = getRoomsDto();

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(8000);
        expected.setBiggest(new RoomDTO("cocina",5,2));
        expected.setSquareFeet(10);

        //ACT
        HouseResponseDTO obtain = service.calculate(houseDTO);

        //ASSERT
        assertEquals(expected,obtain);
        assertEquals(expected.getSquareFeet(), obtain.getSquareFeet());
        assertEquals(expected.getPrice(), obtain.getPrice());
        assertEquals(expected.getBiggest().getName(), obtain.getBiggest().getName());
        assertEquals(expected.getBiggest().getWidth(), obtain.getBiggest().getWidth());
        assertEquals(expected.getBiggest().getLength(), obtain.getBiggest().getLength());
    }
}
