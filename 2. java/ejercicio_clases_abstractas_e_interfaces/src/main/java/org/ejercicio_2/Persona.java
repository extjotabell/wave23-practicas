package org.ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private int edad;

    private List  <String> habilidades = new ArrayList<>();

    public Persona(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}';
    }
}
