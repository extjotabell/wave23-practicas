package com.meli.concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Vehicle {
    private static Integer idCounter = 0;

    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private List<Service> services;
    private Integer countOfOwners;

    public Vehicle(
        String brand,
        String model,
        LocalDate manufacturingDate,
        Integer numberOfKilometers,
        Integer doors,
        Double price,
        String currency,
        List<Service> services,
        Integer countOfOwners
    ) {
        this.id = ++idCounter;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }
}
