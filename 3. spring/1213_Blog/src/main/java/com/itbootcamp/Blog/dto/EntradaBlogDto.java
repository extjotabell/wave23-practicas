package com.itbootcamp.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EntradaBlogDto {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
