package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseDTODataTestBuilder {
    private String name;
    private String address;
    private List<RoomDTO> rooms;

    public HouseDTODataTestBuilder createByDefault() {
        this.name = "Casa de prueba";
        this.address = "Calle falsa 123";
        this.rooms = new ArrayList<>(List.of(
                new RoomDTO("Cocina", 5, 5),
                new RoomDTO("Baño", 2, 2),
                new RoomDTO("Habitación", 4, 4)
        ));
        return this;
    }

    public HouseDTODataTestBuilder createByDefaultWithoutRooms() {
        this.name = "Casa de prueba";
        this.address = "Calle falsa 123";
        this.rooms = new ArrayList<>();
        return this;
    }

    public HouseDTODataTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HouseDTODataTestBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public HouseDTODataTestBuilder withRooms(List<RoomDTO> rooms) {
        this.rooms = new ArrayList<>(rooms);
        return this;
    }

    public HouseDTODataTestBuilder withRoom(RoomDTO room) {
        this.rooms.add(room);
        return this;
    }
    public HouseDTODataTestBuilder withRoom(String name, Integer width, Integer length) {
        this.rooms.add(new RoomDTO(name, width, length));
        return this;
    }

    public HouseDTO build(){
        return new HouseDTO(this.name, this.address, this.rooms);
    }
}