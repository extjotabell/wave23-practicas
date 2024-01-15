package com.example.SeguroAutos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "vehiculo")
@Getter
@Setter
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name = "fechaFabricacion")
    private Integer ano;

    private Integer ruedas;

    @OneToMany
    @JoinColumn(name = "id_vehiculo_denunciado")
    private List<Siniestro> siniestros;
}
