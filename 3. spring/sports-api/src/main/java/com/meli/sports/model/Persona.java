package com.meli.sports.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
}
