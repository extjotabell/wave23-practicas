package com.mercadolibre.calculadorametroscuadrados.utils;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class Builder {

    public static HouseDTO buildHouseDTO() {
        HouseDTO house = new HouseDTO();
        house.setName("Family house");
        house.setAddress("742 Evergreen Terrace");
        house.setRooms(buildRoomsDTO());

        return house;
    }
    public static HouseResponseDTO buildResponseDTO(HouseDTO house) {
        HouseResponseDTO response = new HouseResponseDTO(house);
        response.setSquareFeet(200);
        response.setPrice(160000);
        RoomDTO biggest = house.getRooms().stream().filter(r -> "Living Room".equals(r.getName())).findFirst().get();
        response.setBiggest(biggest);

        return response;
    }

    public static List<RoomDTO> buildRoomsDTO() {
        List<RoomDTO> rooms = new ArrayList<>();
        RoomDTO room1 = new RoomDTO();
        room1.setName("Living Room");
        room1.setWidth(10);
        room1.setLength(12);
        rooms.add(room1);

        RoomDTO room2 = new RoomDTO();
        room2.setName("Kitchen");
        room2.setWidth(8);
        room2.setLength(10);
        rooms.add(room2);

        return rooms;
    }
}
