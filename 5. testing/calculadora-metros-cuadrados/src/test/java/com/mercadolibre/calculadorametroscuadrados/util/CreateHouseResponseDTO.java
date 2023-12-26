package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateHouseResponseDTO {
    public HouseResponseDTO createExpectedResponse() {
        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("Mi casa");
        expected.setAddress("Calle 123");

        List<RoomDTO> rooms = Arrays.asList(
                new RoomDTO("Cocina", 5, 7),
                new RoomDTO("Dormitorio", 4, 6),
                new RoomDTO("Lavanderia", 6, 8)
        );

        expected.setRooms(rooms);
        expected.setSquareFeet(107);
        expected.setPrice(85600);
        expected.setBiggest(new RoomDTO("Lavanderia", 6, 8));

        return expected;
    }
    public HouseResponseDTO createExpectedNoRoomsResponse() {
        HouseResponseDTO expected = new HouseResponseDTO();
        expected.setName("Mi casa");
        expected.setAddress("Calle 123");
        expected.setRooms(Collections.emptyList());
        expected.setSquareFeet(0);
        expected.setPrice(0);
        expected.setBiggest(null);

        return expected;
    }
}
