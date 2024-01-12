package com.example.seguros.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccidentRequestDTO {
    private LocalDate date;
    private Double cost;
    @JsonProperty("vehicle_id")
    private Long vehicleId;
}
