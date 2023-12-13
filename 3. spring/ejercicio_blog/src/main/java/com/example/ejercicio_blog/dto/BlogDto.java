package com.example.ejercicio_blog.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BlogDto {
    private int id;
    private String name;
    private String autor;
    private Date dateRealese;
}
