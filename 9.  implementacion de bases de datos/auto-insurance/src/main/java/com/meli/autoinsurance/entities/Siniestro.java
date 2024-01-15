package com.meli.autoinsurance.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="siniestros")
public class Siniestro {
    @Id
    @Column(name="id_siniestro")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSiniestro;
    @Column(name="fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name="perdida_economica")
    private Double perdidaEconomica;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_vehiculo_denunciado", nullable = false)
    private Vehiculo vehiculoDenunciado;
}