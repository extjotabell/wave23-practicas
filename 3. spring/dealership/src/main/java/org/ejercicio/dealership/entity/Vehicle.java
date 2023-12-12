package org.ejercicio.dealership.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vehicle {
    private String registration;
    private String brand;
    private String model;
    private String manuFacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}
