package com.bootcamp.deportistas.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {


    protected String nombre, apellido, deporte;
    protected Integer edad;

    @Getter
    protected static List<Persona> personas = new ArrayList<>();

    public Persona(String nombre, String apellido, Integer edad, String deporte){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;

        personas.add(this);
    }

}
