package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseDTOTestGenerator {
    public static HouseDTO getHouseDTOWithRooms() {
        RoomDTO roomDTOOne = new RoomDTO();
        roomDTOOne.setName("Room one");
        roomDTOOne.setLength(4);
        roomDTOOne.setWidth(4);

        RoomDTO roomDTOTwo = new RoomDTO();
        roomDTOTwo.setName("Room two");
        roomDTOTwo.setLength(5);
        roomDTOTwo.setWidth(5);

        RoomDTO roomDTOThree = new RoomDTO();
        roomDTOThree.setName("Room three");
        roomDTOThree.setLength(6);
        roomDTOThree.setWidth(6);


        HouseDTO response = new HouseDTO();
        response.setAddress("Av 23 - 15");
        response.setName("House with rooms");
        response.setRooms(new ArrayList<>(List.of(roomDTOOne, roomDTOTwo, roomDTOThree)));
        return response;
    }
    public static HouseResponseDTO getHouseResponseDTOWithRooms() {
        HouseResponseDTO response = new HouseResponseDTO(getHouseDTOWithRooms());
        calculateRoomSquareFeet(response);
        response.setPrice(response.getSquareFeet()*800);
        return response;
    }

    private static void calculateRoomSquareFeet(HouseResponseDTO response) {
        Integer totalSquareFeet = 0;
        RoomDTO biggest = null;
        Integer maxRoom = 0;
        for (RoomDTO room : response.getRooms()) {
            Integer squareFeet = room.getSquareFeet();
            totalSquareFeet += squareFeet;
            if (biggest == null || squareFeet > maxRoom){
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        response.setSquareFeet(totalSquareFeet);
        response.setBiggest(biggest);
    }
    public static HouseDTO getHouseDTOWithoutRooms() {
        HouseDTO response = new HouseDTO();
        response.setAddress("Av 23 - 15");
        response.setName("House with rooms");
        response.setRooms(new ArrayList<>());
        return response;
    }
    public static HouseResponseDTO getHouseResponseDTOWithoutRooms() {
        HouseResponseDTO response = new HouseResponseDTO(getHouseDTOWithoutRooms());
        calculateRoomSquareFeet(response);
        response.setPrice(response.getSquareFeet()*800);
        return response;
    }


}
