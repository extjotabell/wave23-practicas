package com.example.ejerciciodeportistas.entities;


import java.util.List;

public class Persona {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private Deporte deporte;

    public Persona(String nombre, String apellido, int edad, Deporte deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Deporte getDeporte() {
        return deporte;
    }
}