package com.ejercicio.deportes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonaDto {
    private String nombre;
    private String apellido;
    private String deporte;

}
