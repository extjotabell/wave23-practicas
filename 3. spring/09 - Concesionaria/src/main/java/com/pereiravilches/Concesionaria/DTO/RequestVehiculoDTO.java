package com.pereiravilches.Concesionaria.DTO;

import com.pereiravilches.Concesionaria.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class RequestVehiculoDTO {
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private Integer price;
    private String currency;
    private List<Service> services;
    private String countOfOwners;
}
