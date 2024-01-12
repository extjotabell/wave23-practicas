package com.example.seguros.dto;

import com.example.seguros.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccidentResponseDTO {
    private Long id;
    private LocalDate date;
    private Double cost;
    private VehicleResponseDTO vehicle;
}
