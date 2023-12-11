package com.example.covid19.dto;

import com.example.covid19.model.Sintoma;

import java.util.List;

public class PersonaRiesgoDTO {

    private String id;
    private String nombre;
    private String apellido;
    private int edad;

    private List<Sintoma> probablesSintomas;

    public PersonaRiesgoDTO(String id, String nombre, String apellido, int edad, List<Sintoma> probablesSintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.probablesSintomas = probablesSintomas;
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

    public List<Sintoma> getProbablesSintomas() {
        return probablesSintomas;
    }

    public void setProbablesSintomas(List<Sintoma> probablesSintomas) {
        this.probablesSintomas = probablesSintomas;
    }
}
