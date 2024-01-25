package com.melibootcamp.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EntradaBlogDTO {
    private String id;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDateTime fechaPublicacion;

    public EntradaBlogDTO(String id, String tituloBlog, String nombreAutor) {
        this.id = id;
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
    }
}
