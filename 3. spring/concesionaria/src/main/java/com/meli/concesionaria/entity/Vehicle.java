package com.meli.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class Vehicle {
    private long id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Services> services;
    private int countOfOwners;
}
