package com.meli.ejercicioSiniestros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate fecha;
    private Double perdida;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;
}
