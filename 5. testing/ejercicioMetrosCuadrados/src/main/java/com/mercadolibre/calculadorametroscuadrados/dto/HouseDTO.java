package com.mercadolibre.calculadorametroscuadrados.dto;

import java.util.List;

public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  public HouseDTO() {

  }

  public HouseDTO(String name, String address, List<RoomDTO> rooms) {
    this.name = name;
    this.address = address;
    this.rooms = rooms;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }

  public String getName() {
    return this.name;
  }

  public String getAddress() {
    return this.address;
  }

  public List<RoomDTO> getRooms() {
    return this.rooms;
  }
}
