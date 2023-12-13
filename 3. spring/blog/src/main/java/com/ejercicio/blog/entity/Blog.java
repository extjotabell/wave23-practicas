package com.ejercicio.blog.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Blog {
    private Integer id;
    private String titulo;
    private String autor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaPublicacion;
}
