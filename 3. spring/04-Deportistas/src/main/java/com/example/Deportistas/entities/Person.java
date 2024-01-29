package com.example.Deportistas.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String nombre;
    private String apellido;
    private Integer edad;

}
