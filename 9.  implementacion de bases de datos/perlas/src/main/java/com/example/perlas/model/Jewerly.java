package com.example.perlas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Jewerly {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer nro_identificatorio;
    private String nombre;
    private String material;
    private float peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean venta;
}
