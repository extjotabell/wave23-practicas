package com.mercadolibre.calculadorametroscuadrados.dto;

public class HouseResponseDTO extends HouseDTO {
  private Integer squareFeet;
  private Integer price;
  private RoomDTO biggest;

  public HouseResponseDTO() {
  }

  public HouseResponseDTO(HouseDTO house, Integer squareFeet, Integer price, RoomDTO biggest) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
    this.squareFeet = squareFeet;
    this.price = price;
    this.biggest = biggest;
  }

  public HouseResponseDTO(HouseDTO house) {
    this.setName(house.getName());
    this.setAddress(house.getAddress());
    this.setRooms(house.getRooms());
  }

  public void setSquareFeet(Integer squareFeet) {
    this.squareFeet = squareFeet;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public void setBiggest(RoomDTO biggest) {
    this.biggest = biggest;
  }

  public Integer getSquareFeet() {
    return this.squareFeet;
  }

  public Integer getPrice() {
    return this.price;
  }

  public RoomDTO getBiggest() {
    return this.biggest;
  }
}
