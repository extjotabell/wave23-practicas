package com.spring.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sintoma {
    private String codigo, nombre, nivel_de_gravedad;

}
