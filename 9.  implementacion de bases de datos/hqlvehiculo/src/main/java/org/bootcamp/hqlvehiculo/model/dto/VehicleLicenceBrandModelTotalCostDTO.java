package org.bootcamp.hqlvehiculo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class VehicleLicenceBrandModelTotalCostDTO {

    private String licencePlate;
    private String brand;
    private String model;
    private Double totalEconomicCost;

}
