package com.example.seguroAutos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autos", schema = "autos_db")
public class Auto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "patente", nullable = false, length = 100)
    private String patente;
    @Column(name = "marca", nullable = false, length = 100)
    private String marca;
    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;
    @Column(name = "anio_fabricacion", nullable = false, length = 100)
    private String anioFabricacion;
    @Column(name = "num_Ruedas")
    private int numRuedas;

}
