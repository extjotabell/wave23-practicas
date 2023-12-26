package com.meli.ejercicioBlog.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter @AllArgsConstructor
public class EntradaBlog {
    private String id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
