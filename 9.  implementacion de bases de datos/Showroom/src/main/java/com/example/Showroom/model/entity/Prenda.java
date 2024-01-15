package com.example.Showroom.model.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "prenda")
@Getter
@Setter
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private String talle;

    private Integer cantidad;

    private double precio_venta;
}
