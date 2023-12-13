package com.pereiravilches.Concesionaria.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pereiravilches.Concesionaria.DTO.ServiceDTO;
import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @JsonIgnore
    private Integer id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;

    public Vehiculo(RequestVehiculoDTO vehiculoDTO) {
        this.id = new Random().nextInt(1000);
        this.brand = vehiculoDTO.getBrand();
        this.model = vehiculoDTO.getModel();
        this.manufacturingDate = vehiculoDTO.getManufacturingDate();
        this.numberOfKilometers = vehiculoDTO.getNumberOfKilometers();
        this.doors = vehiculoDTO.getDoors();
        this.price = vehiculoDTO.getPrice();
        this.currency = vehiculoDTO.getCurrency();
        this.services = vehiculoDTO.getServices();
        this.countOfOwners = vehiculoDTO.getCountOfOwners();
    }
}
