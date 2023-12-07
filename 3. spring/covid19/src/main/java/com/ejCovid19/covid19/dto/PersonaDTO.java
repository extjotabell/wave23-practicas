package com.ejCovid19.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<SintomaDTO> sintomas;
}
