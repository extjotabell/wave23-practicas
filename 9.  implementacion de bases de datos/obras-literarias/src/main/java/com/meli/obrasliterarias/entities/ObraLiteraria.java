package com.meli.obrasliterarias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras_literarias")
@TypeAlias("obra_literaria")
public class ObraLiteraria {
    private String id;
    private String nombre;
    private String autor;
    @Field(name = "cantidad_de_paginas")
    private Integer cantidadDePaginas;
    private String editorial;
    @Field(name = "primera_publicacion", type = FieldType.Date)
    private LocalDate primeraPublicacion;
}
