package com.example.covid19.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    private static final List<Persona> listaPersonas = new ArrayList<>();

    public Persona(String id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public static List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public static void agregarPersona(Persona nuevaPersona) {
        Persona.listaPersonas.add(nuevaPersona);
    }
}
