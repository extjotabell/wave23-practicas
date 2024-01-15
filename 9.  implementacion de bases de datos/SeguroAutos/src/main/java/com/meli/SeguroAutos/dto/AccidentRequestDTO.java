package com.meli.SeguroAutos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class AccidentRequestDTO {

    @JsonProperty("date_of_accident")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfAccident;
    @JsonProperty("economic_losses")
    private Double economicLosses;
}
