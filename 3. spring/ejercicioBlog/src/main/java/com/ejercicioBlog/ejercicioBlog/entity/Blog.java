package com.ejercicioBlog.ejercicioBlog.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
