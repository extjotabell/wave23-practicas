package org.bootcamp.obrasliterarias.model.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "obras")
@TypeAlias("obra")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Obra {

    @Id
    private String id;

    private String nombre;
    private String autor;

    @JsonAlias("cantidad_paginas")
    private Integer cantidadPaginas;

    private String editorial;

    @JsonAlias("anio_publicacion")
    private String anioPublicacion;

}
