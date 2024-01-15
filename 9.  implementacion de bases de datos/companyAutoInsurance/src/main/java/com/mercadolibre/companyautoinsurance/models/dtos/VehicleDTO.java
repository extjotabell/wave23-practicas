package com.mercadolibre.companyautoinsurance.models.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class VehicleDTO implements Serializable {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("patent_vehicles")
    private String patentVehicles;
    @JsonProperty("brand_vehicles")
    private String brandVehicles;
    @JsonProperty("model_vehicles")
    private String modelVehicles;
    @JsonProperty("year_build_vehicles")
    private Integer yearBuildVehicles;
    @JsonProperty("quantity_wheels_vehicles")
    private Integer quantityWheelsVehicles;
    private Double totalLoss;
}
