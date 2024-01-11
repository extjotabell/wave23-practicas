package com.example.ejemploRelaciones.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "venta")
public class Venta {

    @Id
    private Long id;
    private Date fecha;

    @ManyToMany
    @JoinTable(
            name = "detalle_venta",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    List<Producto> listaProductos;

}
