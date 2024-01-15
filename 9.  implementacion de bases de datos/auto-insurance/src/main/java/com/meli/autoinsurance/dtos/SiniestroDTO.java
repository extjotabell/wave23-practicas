package com.meli.autoinsurance.dtos;

import com.meli.autoinsurance.entities.Vehiculo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class SiniestroDTO {
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    private Vehiculo vehiculoDenunciado;

}
