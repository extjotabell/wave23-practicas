package com.example.literatura.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras_literarias")
@TypeAlias("obra")
public class Obra {
    String id;
    String nombre;
    String autor;
    Integer numPaginas;
    String editorial;
    String anioPublicacion;
}
