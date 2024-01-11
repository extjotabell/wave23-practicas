package com.example.ejemploRelaciones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "producto_id")
    private List<Stock> stock;

    @ManyToMany(mappedBy = "listaProductos")
    List<Venta> ventas;

}
