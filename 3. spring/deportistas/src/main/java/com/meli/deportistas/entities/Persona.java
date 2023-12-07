package com.meli.deportistas.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Persona {
    @Getter
    private static List<Persona> personas = new ArrayList<>();

    private String nombre;
    private String apellido;
    private Integer edad;
    private String deporte;

    public Persona(String nombre, String apellido, Integer edad, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;

        personas.add(this);
    }
}
