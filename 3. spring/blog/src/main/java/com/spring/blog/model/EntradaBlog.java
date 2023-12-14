package com.spring.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
