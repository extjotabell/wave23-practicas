package com.ejCovid19.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
