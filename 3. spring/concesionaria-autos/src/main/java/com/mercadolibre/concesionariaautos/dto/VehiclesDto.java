package com.mercadolibre.concesionariaautos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class VehiclesDto {
    private List<VehicleDto> vehicles;
}
