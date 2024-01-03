package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.List;

public class FactoryOfObject {


    RoomDTO roomDTO2 = new RoomDTO();


    RoomDTO roomDTO3 = new RoomDTO();


    public static RoomDTO roomDto1() {
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Living");
        roomDTO1.setWidth(30);
        roomDTO1.setLength(10);
        return roomDTO1;
    }


    public static RoomDTO roomDto2() {
        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Habitación");
        roomDTO2.setWidth(3);
        roomDTO2.setLength(5);
        return roomDTO2;
    }


    public static RoomDTO roomDto3() {
        RoomDTO roomDTO3 = new RoomDTO();
        roomDTO3.setName("Cocina");
        roomDTO3.setWidth(10);
        roomDTO3.setLength(6);
        return roomDTO3;
    }

    public static HouseDTO houseDto() {
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setAddress("Casa1");
        houseDTO.setName("234");
        houseDTO.setRooms(List.of(roomDto1(), roomDto2(), roomDto3()));

        return houseDTO;
    }
}
