package com.example.ejercicio_edad.service;

import com.example.ejercicio_edad.entities.Persona;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PersonaService {
    private Persona persona = new Persona();

    public Persona concatenarFecha(String dia, String mes, String ano){
        persona.setFechaNacimiento(LocalDate.of(Integer.parseInt(ano),Integer.parseInt(mes),
                Integer.parseInt(dia)));
        persona.setEdad(ChronoUnit.YEARS.between(persona.getFechaNacimiento(),LocalDate.now()));

        return persona;
    }
}
