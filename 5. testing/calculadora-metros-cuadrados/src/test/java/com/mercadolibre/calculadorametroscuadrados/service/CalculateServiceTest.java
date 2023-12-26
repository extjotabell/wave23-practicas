package com.mercadolibre.calculadorametroscuadrados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

public class CalculateServiceTest {
  private CalculateService service;

  @BeforeEach
  void init() {
    this.service = new CalculateService();
  }

  @Test
  void calcWorking() {
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

    HouseResponseDTO houseResponse = this.service.calculate(houseRequest);

    assertEquals(100, room1.getSquareFeet());
    assertEquals(42, room2.getSquareFeet());
    assertEquals(150, room3.getSquareFeet());
    assertEquals(233600, houseResponse.getPrice());
    assertEquals(room3.getName(), houseResponse.getBiggest().getName());
    assertEquals(292, houseResponse.getSquareFeet());
  }
}
