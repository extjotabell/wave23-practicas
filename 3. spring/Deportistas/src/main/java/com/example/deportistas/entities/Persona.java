package com.example.deportistas.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private Deporte deporte;


}
