package org.example;

import java.util.*;

public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private List<String> habilidades;

    public Persona(String nombre, String apellido, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    @Override
    public String toString() {
        String habilidadesSeparadas = "";
        for (String habilidad : this.habilidades) {
            habilidadesSeparadas = habilidadesSeparadas + "\n" + habilidad;
        }
        habilidadesSeparadas = habilidadesSeparadas;
        
        return "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "DNI: " + dni + "\n" +
                "Habilidades: " + habilidadesSeparadas;
    }
}
