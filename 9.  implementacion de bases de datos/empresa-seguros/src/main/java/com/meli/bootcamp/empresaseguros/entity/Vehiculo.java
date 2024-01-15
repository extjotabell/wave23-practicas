package com.meli.bootcamp.empresaseguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "fecha_fabricacion")
    private LocalDate fechaFabricacion;
    private Integer ruedas;

    public Vehiculo(String patente, String marca, String modelo, LocalDate fechaFabricacion, Integer ruedas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.fechaFabricacion = fechaFabricacion;
        this.ruedas = ruedas;
    }
}
