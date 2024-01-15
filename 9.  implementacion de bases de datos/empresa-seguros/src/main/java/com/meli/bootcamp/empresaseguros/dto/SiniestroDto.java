package com.meli.bootcamp.empresaseguros.dto;

import com.meli.bootcamp.empresaseguros.entity.Vehiculo;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class SiniestroDto {
    private LocalDate fecha;
    private Double perdida;
    private VehiculoDto vehiculo;
}
