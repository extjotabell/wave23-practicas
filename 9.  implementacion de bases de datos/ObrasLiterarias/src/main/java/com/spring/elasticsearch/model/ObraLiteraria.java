package com.spring.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Data
@Document(indexName = "obras")
@TypeAlias("obra-literaria")
public class ObraLiteraria {

    @Id
    private String id;
    @Field
    private String nombre;
    private String autor;
    private Integer cantidadDePaginas;
    private Integer anioPublicacion;
    private String editorial;
}