package com.meli.bootcamp.productos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer stock;
}