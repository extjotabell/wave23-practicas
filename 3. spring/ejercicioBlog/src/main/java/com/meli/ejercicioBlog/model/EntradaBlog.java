package com.meli.ejercicioBlog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class EntradaBlog {
    private String id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
