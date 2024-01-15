package com.meli.SeguroAutos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class VehicleLossDTO {

    @JsonProperty("patent")
    private String patent;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("economic_losses")
    private Double economicLosses;

}
