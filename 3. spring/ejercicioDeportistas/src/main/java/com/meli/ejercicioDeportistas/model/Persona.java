package com.meli.ejercicioDeportistas.model;

import com.meli.ejercicioDeportistas.model.dto.PersonaResponseDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deportes;

    public PersonaResponseDTO toResponseDTO(){
        return new PersonaResponseDTO(nombre, apellido, deportes.stream().map(Deporte::getNombre).toList());
    }
}
