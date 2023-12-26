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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class CalculateRestControllerTest {
    CalculateRestController calculateRestController;

    @BeforeEach
    private void setUp() {
        this.calculateRestController = new CalculateRestController();
    }

    @Test
    void calculateTestOk(){
        //Arrange
        RoomDTO room = new RoomDTO("room1", 10, 10);
        List<RoomDTO> rooms = List.of(room);
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", rooms);
        HouseResponseDTO response = new HouseResponseDTO(100, 80000, room);

        //Act
        HouseResponseDTO responseReturned = calculateRestController.calculate(houseDTO);

        //Assert
        assertEquals(response.getPrice(), responseReturned.getPrice());
        assertEquals(response.getSquareFeet(), responseReturned.getSquareFeet());
        assertEquals(response.getBiggest(), responseReturned.getBiggest());
    }
}
