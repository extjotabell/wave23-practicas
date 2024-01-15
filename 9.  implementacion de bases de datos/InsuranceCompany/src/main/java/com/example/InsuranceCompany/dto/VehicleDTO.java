package com.example.InsuranceCompany.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @JsonProperty("year_of_production")
    private Integer yearOfProduction;
    @JsonProperty("number_of_wheels")
    private Integer numberOfWheels;
}
