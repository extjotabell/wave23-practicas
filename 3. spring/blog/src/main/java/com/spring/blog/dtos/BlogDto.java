package com.spring.blog.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogDto {
    private Long id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
