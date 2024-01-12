package com.spring.SeguroAutos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
