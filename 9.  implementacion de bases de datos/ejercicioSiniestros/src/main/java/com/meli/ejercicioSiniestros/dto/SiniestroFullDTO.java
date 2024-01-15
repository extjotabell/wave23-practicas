package com.meli.ejercicioSiniestros.dto;

import com.meli.ejercicioSiniestros.model.Vehiculo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class SiniestroFullDTO {
    private Long id;
    private LocalDate fecha;
    private Double perdida;
    private VehiculoBasicDTO vehiculoDenunciado;
}
