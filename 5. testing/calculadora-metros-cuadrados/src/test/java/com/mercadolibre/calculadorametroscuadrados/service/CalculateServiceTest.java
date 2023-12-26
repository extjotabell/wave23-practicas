package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

  CalculateService calculateService = new CalculateService();

  @Test
  void verifyRoomBigger() {
    //Arrange
    HouseDTO houseDTO = new HouseDTO();
    RoomDTO bigRoom = new RoomDTO();
    RoomDTO smallRoom = new RoomDTO();
    bigRoom.setWidth(30);
    bigRoom.setLength(40);
    smallRoom.setWidth(20);
    smallRoom.setLength(30);
    houseDTO.setRooms(List.of(smallRoom, bigRoom));
    //Act
    RoomDTO bigRoomResult = calculateService.calculate(houseDTO).getBiggest();
    //Assert
    Assertions.assertEquals(bigRoom, bigRoomResult);
  }

  @Test
  void verifySquareFeetCalcPerRoomTest() {
    //Arrange
    HouseDTO houseDTO = new HouseDTO();
    RoomDTO bigRoom = new RoomDTO();
    RoomDTO smallRoom = new RoomDTO();
    bigRoom.setWidth(30);
    bigRoom.setLength(40);
    smallRoom.setWidth(20);
    smallRoom.setLength(30);
    houseDTO.setRooms(List.of(smallRoom, bigRoom));
    List<Integer> expected = List.of(20*30,30*40);
    //Act
    List<Integer> result = calculateService.calculate(houseDTO).getRooms().stream()
        .mapToInt(RoomDTO::getSquareFeet).boxed().collect(
            Collectors.toList());
    //Assert
    Assertions.assertEquals(expected, result);
  }
  @Test
  void verifyPriceHouseTest() {
    //Arrange
    HouseDTO houseDTO = new HouseDTO();
    RoomDTO bigRoom = new RoomDTO();
    RoomDTO smallRoom = new RoomDTO();
    bigRoom.setWidth(30);
    bigRoom.setLength(40);
    smallRoom.setWidth(20);
    smallRoom.setLength(30);
    houseDTO.setRooms(List.of(smallRoom, bigRoom));
    Integer expected = (30*40 + 20*30)*800;
    //Act
    Integer result = calculateService.calculate(houseDTO).getPrice();
    //Assert
    Assertions.assertEquals(expected, result);
  }


}
