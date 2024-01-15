package com.mercadolibre.companyautoinsurance.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter @Setter

@AllArgsConstructor @NoArgsConstructor
public class AccidentDTO implements Serializable {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("accident_date")
    private Date accidentDate;
    @JsonProperty("economic_loss")
    private double economicLoss;
    @JsonProperty("vehicle_id")
    private Integer vehicleId;
}
