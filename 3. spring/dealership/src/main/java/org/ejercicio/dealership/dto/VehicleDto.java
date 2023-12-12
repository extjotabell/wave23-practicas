package org.ejercicio.dealership.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.ejercicio.dealership.entity.Service;

import java.util.List;

@Data
@AllArgsConstructor
public class VehicleDto {
    private String brand;
    private String model;
    private String manuFacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
}
