package com.bootcampW22.EjercicioGlobal.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @NotNull
    private Long id;
    @NotNull @NotEmpty(message = "El campo brand no puede estar vacío")
    private String brand;
    @NotNull @NotEmpty(message = "El campo model no puede estar vacío")
    private String model;
    @NotNull @NotEmpty(message = "El campo registration no puede estar vacío")
    private String registration;
    @NotNull @NotEmpty(message = "El campo color no puede estar vacío")
    private String color;
    @Min(value = 1950, message = "El año no puede ser menor a 1950")
    private int year;
    @NotNull @NotEmpty(message = "El campo max_speed no puede estar vacío")
    private String max_speed;
    @Min(value = 2, message = "El número de pasajeros no puede ser menor a 2")
    @Max(value = 8, message = "El número de pasajeros no puede ser mayor a 8")
    @NotNull
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;
}
