package com.example.clasenosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "productos")
@TypeAlias("producto")
public class Producto {
    @Id
    private String id;
    private  String nombre;
    private  String tipo;
    private String precio;
    private String costo;
    private String cantidad;
}
