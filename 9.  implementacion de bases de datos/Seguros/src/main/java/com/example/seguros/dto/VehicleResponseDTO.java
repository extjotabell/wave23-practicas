package com.example.seguros.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleResponseDTO {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private LocalDate yearOfFabrication;
    private int wheels;
}
