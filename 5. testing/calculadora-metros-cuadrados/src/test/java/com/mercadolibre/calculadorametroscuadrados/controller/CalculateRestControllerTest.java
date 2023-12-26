package com.mercadolibre.calculadorametroscuadrados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {
  @Mock
  CalculateService service;

  @InjectMocks
  CalculateRestController controller;

  @Test
  void controllerWorking() {
    HouseDTO houseRequest = new HouseDTO();
    houseRequest.setName("Casa Linda");
    houseRequest.setAddress("Independencia 1234");
    RoomDTO room1 = new RoomDTO();
    room1.setName("Habitacion 1");
    room1.setLength(10);
    room1.setWidth(10);
    RoomDTO room2 = new RoomDTO();
    room2.setName("Banio");
    room2.setLength(7);
    room2.setWidth(6);
    RoomDTO room3 = new RoomDTO();
    room3.setName("Living");
    room3.setLength(15);
    room3.setWidth(10);
    houseRequest.setRooms(List.of(room1, room2, room3));

    HouseResponseDTO serviceMockResponseDto = new HouseResponseDTO(houseRequest);
    serviceMockResponseDto.setSquareFeet(292);
    serviceMockResponseDto.setPrice(233600);
    serviceMockResponseDto.setBiggest(room3);

    when(service.calculate(houseRequest)).thenReturn(serviceMockResponseDto);

    HouseResponseDTO serviceResponseDto = controller.calculate(houseRequest);

    verify(service, atLeastOnce()).calculate(houseRequest);

    assertEquals(serviceMockResponseDto.getPrice(), serviceResponseDto.getPrice());
  }
}
