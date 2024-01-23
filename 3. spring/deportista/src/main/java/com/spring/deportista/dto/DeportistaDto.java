package com.spring.deportista.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeportistaDto {
    private String nombre;
    private String apellido;
    private String deporte;
}
