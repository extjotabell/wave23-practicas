package com.blog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
