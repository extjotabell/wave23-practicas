package com.mercadolibre.seguro_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinisterDTO {
    private Integer id;
    private LocalDate date;
    private Double economicLoss;
    private VehicleDTO vehicle;
}
