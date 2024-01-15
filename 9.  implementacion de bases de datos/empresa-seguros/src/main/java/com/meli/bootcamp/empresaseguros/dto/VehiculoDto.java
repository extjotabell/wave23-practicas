package com.meli.bootcamp.empresaseguros.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@AllArgsConstructor
@Data
public class VehiculoDto {
    private String patente;
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private Integer ruedas;
}
