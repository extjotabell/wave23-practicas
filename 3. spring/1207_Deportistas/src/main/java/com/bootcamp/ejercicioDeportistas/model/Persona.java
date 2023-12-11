package com.bootcamp.ejercicioDeportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

    private static final List<Persona> listaPersonas = new ArrayList<>();

    private String nombre;
    private String apellido;
    private int edad;

    public static List<Persona> getListaPersonas(){
        return listaPersonas;
    }

    public static void agregarPersona(Persona nuevaPersona){
        listaPersonas.add(nuevaPersona);
    }

}
