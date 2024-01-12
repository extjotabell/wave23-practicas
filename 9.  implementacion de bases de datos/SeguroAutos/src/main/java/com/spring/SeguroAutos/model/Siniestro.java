package com.spring.SeguroAutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;
    @ManyToOne()
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo VehiculoDenunciado;
}
