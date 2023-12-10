package com.deportistas.deportistas.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
