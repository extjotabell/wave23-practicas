package com.mercadolibre.companyautoinsurance.models.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class VehicleWithTotalLossDTO {
    private List<VehicleDTO> vehicles;
    private Double totalLoss;
}
