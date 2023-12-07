package com.spring.edaddeunapersona.entities;

import lombok.Getter;

@Getter
public class Persona {
    private int edad;
    private String nombre;

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona(int edad, String nombre) {
        this.edad = edad;
        this.nombre = nombre;
    }
}
