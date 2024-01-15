package com.meli.bootcamp.productos.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
@AllArgsConstructor
@Data
@Document(indexName = "productos")
public class Product {
    private String id;
    private String nombre;
    private String tipo;
    private Double precioVenta;
    private Double precioCosto;
    private Integer stock;
}
