package com.example.ejercicio_blog.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Data
public class Blog {
    private int id;
    private String name;
    private String autor;
    private Date dateRealese;
}
