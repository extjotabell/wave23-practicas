package com.spring.covid19.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Persona {
    private static int id = 0;
    private int edad;
    private String nombre, apellido;
    private List<Sintoma> sintomas;
}
