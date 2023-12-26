package com.mercadolibre.calculadorametroscuadrados.dto;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HouseDTO houseDTO = (HouseDTO) o;
    return Objects.equals(getName(), houseDTO.getName())
            && Objects.equals(getAddress(), houseDTO.getAddress()) && CollectionUtils.isEqualCollection(getRooms(), houseDTO.getRooms());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getAddress(), getRooms());
  }

  public HouseDTO() {

  }

  public HouseDTO(String name, String address, List<RoomDTO> rooms) {
    this.name = name;
    this.address = address;
    this.rooms = rooms;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<RoomDTO> getRooms() {
    return rooms;
  }

  public void setRooms(List<RoomDTO> rooms) {
    this.rooms = rooms;
  }
}
