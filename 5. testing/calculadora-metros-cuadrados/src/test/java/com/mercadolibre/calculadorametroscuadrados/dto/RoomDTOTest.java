package com.mercadolibre.calculadorametroscuadrados.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RoomDTOTest {

  @Test
  void verifySquareFeetCalcTest() {
    //Arrange
    RoomDTO roomDTO = new RoomDTO();
    Integer length = 30;
    Integer width = 60;
    roomDTO.setLength(length);
    roomDTO.setWidth(width);
    Integer expected = length * width;
    //Act
    Integer result = roomDTO.getSquareFeet();
    //Assert
    Assertions.assertEquals(expected, result);
  }

}
