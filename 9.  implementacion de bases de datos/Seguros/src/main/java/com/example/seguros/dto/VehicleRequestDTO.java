package com.example.seguros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleRequestDTO {
    private String patent;
    private String brand;
    private String model;
    private LocalDate yearOfFabrication;
    private int wheels;
}

