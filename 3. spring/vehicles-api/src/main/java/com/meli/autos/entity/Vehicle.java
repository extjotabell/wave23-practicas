package com.meli.autos.entity;

import java.time.LocalDate;
import java.util.Random;
import java.util.List;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Vehicle {
    private long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;

    public Vehicle(){
        this.id = Math.abs(new Random().nextLong()) % 1000;
    }
}
