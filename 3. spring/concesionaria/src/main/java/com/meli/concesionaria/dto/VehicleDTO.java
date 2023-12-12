package com.meli.concesionaria.dto;

import com.meli.concesionaria.entity.Services;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class VehicleDTO {
    private long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServicesDTO> services;
    private int countOfOwners;
}
