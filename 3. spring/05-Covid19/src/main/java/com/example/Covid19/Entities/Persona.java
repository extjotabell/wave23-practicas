package com.example.Covid19.Entities;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;

    static final public List<Persona> personas = new ArrayList<>();

    static {
        personas.add(new Persona(1,"Juan", "Mendez", 30));
        personas.add(new Persona(2, "Maria", "Fernandez", 70));
        personas.add(new Persona(3, "Fernanda", "Arteaga", 65));
        personas.add(new Persona(4, "Alicia","Pastrana", 40));
    }
    public Persona(Integer id, String nombre, String apellido, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
