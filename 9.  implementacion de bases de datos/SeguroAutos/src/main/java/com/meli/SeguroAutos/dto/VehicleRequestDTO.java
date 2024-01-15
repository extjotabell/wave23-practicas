package com.meli.SeguroAutos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VehicleRequestDTO {

    @JsonProperty("patent")
    private String patent;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("year_of_production")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate yearOfProduction;
    @JsonProperty("number_of_wheels")
    private int numberOfWheels;
}
