package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class FactoryDTO {

    public static HouseDTO factoryHouseDTO(){

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("Prueba");
        houseDTO.setAddress("Diagonal 78J sur");
        houseDTO.setRooms(factoryListRoomDTO());

        return houseDTO;
    }

    public static List<RoomDTO> factoryListRoomDTO(){
        return new ArrayList<>(List.of(
                factoryRoomDTO("Room 1", 10, 50),
                factoryRoomDTO("Room 2", 15, 30)
        ));
    }

    public static RoomDTO factoryRoomDTO(String name, Integer width, Integer length){
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setName(name);
        roomDTO.setWidth(width);
        roomDTO.setLength(length);
        return roomDTO;
    }

    public static HouseResponseDTO factoryHouseResponseDTO(HouseDTO houseDTO, Integer squareFeet, Integer price, RoomDTO biggest){
        HouseResponseDTO houseResponseDTO = new HouseResponseDTO(houseDTO);
        houseResponseDTO.setSquareFeet(squareFeet);
        houseResponseDTO.setPrice(price);
        houseResponseDTO.setBiggest(biggest);

        return houseResponseDTO;

    }

}
