package com.ejCovid19.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SintomaDTO {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
}
