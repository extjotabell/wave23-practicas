package com.meli.bootcamp.empresaseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double perdida;
    @ManyToOne
    @JoinColumn(name ="vehiculo_id")
    private Vehiculo vehiculo;

    public Siniestro(LocalDate fecha, Double perdida, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.perdida = perdida;
        this.vehiculo = vehiculo;
    }
}
