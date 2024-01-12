package com.example.elastic.entity;

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
    String id;
    String nombre;
    Double precio;
    Integer cantidad;
    String tipo;
}
