package com.ospina.showroom.modelo.entidad;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private String fecha;
    private double total;
    private String medioPago;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "venta_numero")
    private List<Prenda> prendas;
}
