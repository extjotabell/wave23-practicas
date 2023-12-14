package com.ejercicioBlog.ejercicioBlog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponseDTO {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
