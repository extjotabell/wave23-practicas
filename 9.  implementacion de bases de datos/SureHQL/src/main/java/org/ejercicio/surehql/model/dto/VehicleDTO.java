package org.ejercicio.surehql.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    private LocalDate yearOfProduction;
    private Integer wheels;
}
