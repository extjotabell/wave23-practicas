package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

    @Mock
    CalculateService service;

    @InjectMocks
    CalculateRestController controller;

    private RoomDTO roomDTO1;
    private RoomDTO roomDTO2;
    private RoomDTO roomDTO3;
    private HouseDTO houseDTO;

    @BeforeEach
    private void setUp() {
        roomDTO1 = new RoomDTO();
        roomDTO1.setName("Living");
        roomDTO1.setWidth(30);
        roomDTO1.setLength(10);

        roomDTO2 = new RoomDTO();
        roomDTO2.setName("Habitación");
        roomDTO2.setWidth(3);
        roomDTO2.setLength(5);

        roomDTO3 = new RoomDTO();
        roomDTO3.setName("Cocina");
        roomDTO3.setWidth(10);
        roomDTO3.setLength(6);

        houseDTO = new HouseDTO();
        houseDTO.setName("Casa1");
        houseDTO.setAddress("234");
        houseDTO.setRooms(List.of(roomDTO1, roomDTO2, roomDTO3));
    }

    @Test
    void calculateTest() {

        // Arrange
        HouseResponseDTO responseDTO = new HouseResponseDTO(houseDTO);
        responseDTO.setBiggest(roomDTO1);
        responseDTO.setSquareFeet(375);
        responseDTO.setPrice(300000); // 375 * 800

        when(service.calculate(houseDTO)).thenReturn(responseDTO);

        //verify(service, atLeast(1)).calculate(houseDTO);

        // Act
        HouseResponseDTO actual = controller.calculate(houseDTO);

        // Assert
        assertEquals(responseDTO.getBiggest(), actual.getBiggest());
        assertEquals(responseDTO.getSquareFeet(), actual.getSquareFeet());
        assertEquals(responseDTO.getPrice(), actual.getPrice());
    }

}
