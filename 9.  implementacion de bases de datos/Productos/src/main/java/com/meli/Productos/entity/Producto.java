package com.meli.Productos.entity;

import com.meli.Productos.dto.ProductoDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity @Document(indexName = "productos")
public class Producto {

    @Id
    private String id;

    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Long cantidadDisponible;

    public Producto(ProductoDto productoDto) {
        this.nombre = productoDto.getNombre();
        this.tipo = productoDto.getTipo();
        this.precioVenta = productoDto.getPrecioVenta();
        this.precioCosto = productoDto.getPrecioCosto();
        this.cantidadDisponible = productoDto.getCantidadDisponible();
    }
}
