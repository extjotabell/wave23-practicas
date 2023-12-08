package com.spring.covid19.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomasDto {
    private String nombre, nivel_de_gravedad;
}
