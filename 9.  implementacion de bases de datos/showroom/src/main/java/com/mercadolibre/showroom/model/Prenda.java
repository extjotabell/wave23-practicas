package com.mercadolibre.showroom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prenda", schema = "showroom_db", catalog = "")
public class Prenda {

    @Id
    private Integer codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precio_venta;

    @ManyToMany(mappedBy = "prendas")
    private List<Venta> ventas;
}
