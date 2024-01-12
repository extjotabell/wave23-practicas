package com.example.hql_vehiculos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehiculo")
@Getter @Setter
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "patente")
    private String patente;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer ano;

    @Column(name = "cantidad_ruedas")
    private Integer ruedas;

    @OneToMany
    @JoinColumn(name = "id_vehiculo_denunciado")
    private List<Siniestro> siniestros;
}
