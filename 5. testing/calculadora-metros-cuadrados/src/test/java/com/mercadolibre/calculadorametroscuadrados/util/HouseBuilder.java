package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseBuilder {
    private String name;
    private String address;
    private List<RoomDTO> rooms;

    public HouseBuilder createByDefault() {
        RoomDTO kitchen = new RoomDTO();
        kitchen.setName("Cocina");
        kitchen.setWidth(5);
        kitchen.setLength(5);

        RoomDTO bathroom = new RoomDTO();
        bathroom.setName("Baño");
        bathroom.setWidth(2);
        bathroom.setLength(2);

        RoomDTO bedroom = new RoomDTO();
        bedroom.setName("Habitación");
        bedroom.setWidth(4);
        bedroom.setLength(4);

        this.name = "Fake house";
        this.address = "Fake street 123";
        this.rooms = new ArrayList<>(List.of(kitchen, bathroom, bedroom));

        return this;
    }

    public HouseBuilder createByDefaultWithoutRooms() {
        this.name = "Fake house";
        this.address = "Fake street 123";
        this.rooms = new ArrayList<>();
        return this;
    }

    public HouseBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public HouseBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public HouseBuilder withRooms(List<RoomDTO> rooms) {
        this.rooms = new ArrayList<>(rooms);
        return this;
    }

    public HouseBuilder withRoom(RoomDTO room) {
        this.rooms.add(room);
        return this;
    }
    public HouseBuilder withRoom(String name, Integer width, Integer length) {
        RoomDTO room = new RoomDTO();
        room.setName(name);
        room.setWidth(width);
        room.setLength(length);

        this.rooms.add(room);

        return this;
    }

    public HouseDTO build(){
        HouseDTO house = new HouseDTO();
        house.setName(this.name);
        house.setAddress(this.address);
        house.setRooms(this.rooms);

        return house;
    }
}
