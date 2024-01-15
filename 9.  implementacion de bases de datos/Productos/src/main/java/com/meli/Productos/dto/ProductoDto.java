package com.meli.Productos.dto;

import com.meli.Productos.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto implements Serializable {
    String id;
    String nombre;
    String tipo;
    Double precioVenta;
    Double precioCosto;
    Long cantidadDisponible;

    public ProductoDto(String nombre, String tipo, Double precioVenta, Double precioCosto, Long cantidadDisponible) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.cantidadDisponible = cantidadDisponible;
    }

    public ProductoDto(Producto producto) {
        this.id = producto.getId();
        this.nombre = producto.getNombre();
        this.tipo = producto.getTipo();
        this.precioVenta = producto.getPrecioVenta();
        this.precioCosto = producto.getPrecioCosto();
        this.cantidadDisponible = producto.getCantidadDisponible();
    }
}