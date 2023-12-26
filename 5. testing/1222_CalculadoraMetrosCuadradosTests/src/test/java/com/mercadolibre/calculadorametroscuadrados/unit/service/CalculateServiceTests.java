package com.mercadolibre.calculadorametroscuadrados.unit.service;


import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculateServiceTests {

    @Test
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

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(90);
        expected.setBiggest(room1DTO);
        expected.setPrice(72000);

        CalculateService service = new CalculateService();

        //Act
        HouseResponseDTO resultHouse = service.calculate(houseDTO);

        //Assert
        /*
        Assertions.assertEquals(expected.getSquareFeet(), resultHouse.getSquareFeet());
        Assertions.assertEquals(expected.getBiggest(), resultHouse.getBiggest());
        Assertions.assertEquals(expected.getPrice(), resultHouse.getPrice());
        */

        Assertions.assertEquals(expected, resultHouse);
    }

    @Test
    void calculateSingleRoomOk(){
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

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(36);
        expected.setBiggest(room1DTO);
        expected.setPrice(28800);

        CalculateService service = new CalculateService();

        //Act
        HouseResponseDTO resultHouse = service.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expected, resultHouse);
    }

    @Test
    public void calculateNoneRoomOk(){
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House test name");
        houseDTO.setAddress("Test address");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(0);
        expected.setBiggest(null);
        expected.setPrice(0);

        CalculateService service = new CalculateService();

        //Act
        HouseResponseDTO resultHouse = service.calculate(houseDTO);

        //Assert
        Assertions.assertEquals(expected, resultHouse);
    }

}
