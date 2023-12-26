package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class UtilsTest {

    public static RoomDTO getRoomDTO(String name, Integer width, Integer length) {
        RoomDTO roomToReturn = new RoomDTO();
        roomToReturn.setName(name);
        roomToReturn.setLength(length);
        roomToReturn.setWidth(width);
        return roomToReturn;
    }

    public static HouseDTO getHouseDTO(String name, String address, List<RoomDTO> rooms) {
        HouseDTO houseToReturn = new HouseDTO();
        houseToReturn.setName(name);
        houseToReturn.setAddress(address);
        houseToReturn.setRooms(rooms);
        return houseToReturn;
    }

    public static HouseResponseDTO getResponseHouseDTO(HouseDTO houseDTO, RoomDTO roomForHouse) {
        HouseResponseDTO houseResponseToReturn = new HouseResponseDTO(houseDTO);
        houseResponseToReturn.setPrice(12000);
        houseResponseToReturn.setSquareFeet(15);
        houseResponseToReturn.setBiggest(roomForHouse);
        return houseResponseToReturn;
    }
}
