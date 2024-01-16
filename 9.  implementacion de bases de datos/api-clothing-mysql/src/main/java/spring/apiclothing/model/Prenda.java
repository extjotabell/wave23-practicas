package spring.apiclothing.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Integer talle;
    private Integer cantidad;
    private Double precio_venta;
    @ManyToMany(mappedBy = "listaDePrendas")
    private List<Venta> ventas;

}
