package com.ejercicioBlog.ejercicioBlog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BlogRequestDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
