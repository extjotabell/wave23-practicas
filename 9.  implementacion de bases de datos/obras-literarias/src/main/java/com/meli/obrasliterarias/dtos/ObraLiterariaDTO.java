package com.meli.obrasliterarias.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ObraLiterariaDTO {
    private String nombre;
    private String autor;
    @JsonAlias("cantidad_de_paginas")
    private Integer cantidadDePaginas;
    private String editorial;
    @JsonAlias("primera_publicacion")
    private LocalDate primeraPublicacion;

}
