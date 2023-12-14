package com.itbootcamp.EjercicioVehiculos.dto.request;

import com.itbootcamp.EjercicioVehiculos.entity.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VehicleRequestDto {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
    private List<VehicleService> servicesList;
}
