package com.ejercicio.sintoma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDto {
    private String nombre;
    private String gravedad;
}
