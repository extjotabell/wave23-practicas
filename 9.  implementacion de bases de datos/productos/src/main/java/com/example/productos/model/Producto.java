package com.example.productos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "producto")
@TypeAlias("producto")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String tipo;
    private Double precio;
    private Integer cantidad;
}
