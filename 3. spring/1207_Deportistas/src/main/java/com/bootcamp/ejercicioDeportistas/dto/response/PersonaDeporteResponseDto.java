package com.bootcamp.ejercicioDeportistas.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDeporteResponseDto {
    private String nombre;
    private String apellido;
    private String deporte;
}
