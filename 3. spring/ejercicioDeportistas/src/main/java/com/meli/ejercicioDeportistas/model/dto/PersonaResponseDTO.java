package com.meli.ejercicioDeportistas.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonaResponseDTO {
    private String nombre;
    private String apellido;
    private List<String> deporte;
}
