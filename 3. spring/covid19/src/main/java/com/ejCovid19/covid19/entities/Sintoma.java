package com.ejCovid19.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivelDeGravedad;
}
