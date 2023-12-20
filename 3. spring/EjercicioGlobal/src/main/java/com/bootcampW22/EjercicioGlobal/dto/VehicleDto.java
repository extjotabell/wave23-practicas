package com.bootcampW22.EjercicioGlobal.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehicleDto {
    @NotNull
    private Long id;
    @NotNull
    private String brand;
    @NotNull
    private String model;
    @NotNull
    private String registration;
    @NotNull
    private String color;
    @NotNull
    private int year;
    @NotNull
    private String max_speed;
    @NotNull
    private int passengers;
    @NotNull
    private String fuel_type;
    @NotNull
    private String transmission;
    @NotNull
    private double height;
    @NotNull
    private double width;
    @NotNull
    private double weight;

    @JsonIgnore
    @AssertTrue(message = "La velocidad debe de ser un dato numerico.")
    public boolean isNumericStringValid() {
        try {
            Integer.parseInt(max_speed);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
