package org.example.Ejercicio2;

import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private List<String> habilidades;

    public Persona(String nombre, String apellido, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad='" + edad + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}