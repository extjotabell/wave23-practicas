package com.itbootcamp.EjercicioVehiculos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vehicle {

    private static int totalVehicles = 0;

    private int id;
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private List<VehicleService> servicesList;
    private String countOfOwners;

    public static int getNewId(){ return ++totalVehicles; }
}
