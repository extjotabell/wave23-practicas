package com.mercadolibre.calculadorametroscuadrados.unit.controller;

import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTests {

    @Mock
    CalculateService calculateService;

    @InjectMocks
    CalculateRestController controller;

    @Test
    @DisplayName("Calculate house with various rooms")
    void calculateMultipleRoomsOk(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House test name");
        houseDTO.setAddress("Test address");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1DTO = new RoomDTO();
        room1DTO.setName("Room 1 test name");
        room1DTO.setWidth(7);
        room1DTO.setLength(7);
        roomDTOList.add(room1DTO);

        RoomDTO room2DTO = new RoomDTO();
        room2DTO.setName("Room 2 test name");
        room2DTO.setWidth(5);
        room2DTO.setLength(5);
        roomDTOList.add(room2DTO);

        RoomDTO room3DTO = new RoomDTO();
        room3DTO.setName("Room 3 test name");
        room3DTO.setWidth(4);
        room3DTO.setLength(4);
        roomDTOList.add(room3DTO);

        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO serviceResponse = new HouseResponseDTO(houseDTO);
        serviceResponse.setSquareFeet(98);
        serviceResponse.setBiggest(room1DTO);
        serviceResponse.setPrice(72000);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(90);
        expected.setBiggest(room1DTO);
        expected.setPrice(72000);

        //Mockito.when(calculateService.calculate(houseDTO)).thenReturn(serviceResponse);

        //Act
        HouseResponseDTO resultHouse = controller.calculate(houseDTO);

        Assertions.assertEquals(expected, resultHouse);
    }

   @Test
   @DisplayName("Calculate house with a single room")
   public void calculateSingleRoomOk(){
       //Arrange
       HouseDTO houseDTO = new HouseDTO();
       houseDTO.setName("House test name");
       houseDTO.setAddress("Test address");

       List<RoomDTO> roomDTOList = new ArrayList<>();
       RoomDTO room1DTO = new RoomDTO();
       room1DTO.setName("Room 1 test name");
       room1DTO.setWidth(9);
       room1DTO.setLength(4);
       roomDTOList.add(room1DTO);

       houseDTO.setRooms(roomDTOList);

       HouseResponseDTO serviceResponse = new HouseResponseDTO(houseDTO);
       serviceResponse.setSquareFeet(36);
       serviceResponse.setBiggest(room1DTO);
       serviceResponse.setPrice(28800);

       HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
       expected.setSquareFeet(36);
       expected.setBiggest(room1DTO);
       expected.setPrice(28800);

       //Mockito.when(calculateService.calculate(houseDTO)).thenReturn(serviceResponse);

       //Act
       HouseResponseDTO resultHouse = controller.calculate(houseDTO);

       //Assert
       Assertions.assertEquals(expected, resultHouse);
   }

   @Test
   @DisplayName("Calculate house with zero rooms")
   void calculateNoneRoomOk(){
       //Arrange
       HouseDTO houseDTO = new HouseDTO();
       houseDTO.setName("House test name");
       houseDTO.setAddress("Test address");

       List<RoomDTO> roomDTOList = new ArrayList<>();
       houseDTO.setRooms(roomDTOList);

       HouseResponseDTO serviceResponse = new HouseResponseDTO(houseDTO);
       serviceResponse.setSquareFeet(0);
       serviceResponse.setBiggest(null);
       serviceResponse.setPrice(0);

       HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
       expected.setSquareFeet(0);
       expected.setBiggest(null);
       expected.setPrice(0);

       //Mockito.when(calculateService.calculate(houseDTO)).thenReturn(serviceResponse);

       //Act
       HouseResponseDTO resultHouse = controller.calculate(houseDTO);

       //Assert
       Assertions.assertEquals(expected, resultHouse);
   }


}
