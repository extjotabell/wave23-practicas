package com.ospina.seguros.modelo.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "siniestro")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate fecha;
    @Column(name = "perdida_economica")
    Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculoDenunciado;


}
