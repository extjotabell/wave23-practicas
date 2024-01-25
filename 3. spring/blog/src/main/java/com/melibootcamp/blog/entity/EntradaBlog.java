package com.melibootcamp.blog.entity;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlog {

    private String id;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDateTime fechaPublicacion;

    public EntradaBlog(String id, String tituloBlog, String nombreAutor) {
        this.id = id;
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = LocalDateTime.now();
    }
}
