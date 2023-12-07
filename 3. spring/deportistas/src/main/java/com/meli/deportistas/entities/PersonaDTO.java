package com.meli.deportistas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private Integer edad;
    private String deporte;

    public PersonaDTO(String nombre, String apellido, Integer edad, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.deporte = deporte;
    }
}
