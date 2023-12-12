package com.example.concesionariaautos.entity;

import com.example.concesionariaautos.dto.VehicleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
public class Vehicle {
    private static int countId = 0;
    private int id;
    private String brand;
    private String model;
    private Date manufacturingDate;
    private double numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<ServiceVehicle> services;
    private int countOfOwners;

    public Vehicle(String brand, String model, Date manufacturingDate, double numberOfKilometers, int doors,
                   double price, String currency, List<ServiceVehicle> services, int countOfOwners) {
        this.id = countId++;
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

    public Vehicle() {
        this.id=countId++;
    }

    public VehicleDTO mapToDTO() {
        return new VehicleDTO(brand,
                              model,
                              manufacturingDate,
                              numberOfKilometers,
                              doors,
                              price,
                              currency,
                              countOfOwners
        );
    }

}
