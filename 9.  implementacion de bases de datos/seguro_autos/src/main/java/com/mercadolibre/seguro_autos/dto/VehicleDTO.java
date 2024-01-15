package com.mercadolibre.seguro_autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {
    private Integer id;
    private String patent;
    private String brand;
    private String model;
    private Integer yearProduction;
    private Integer numberWheels;
    private List<SinisterDTO> sinisters;
}
