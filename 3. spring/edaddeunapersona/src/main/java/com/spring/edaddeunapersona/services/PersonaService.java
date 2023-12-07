package com.spring.edaddeunapersona.services;

import com.spring.edaddeunapersona.entities.Persona;

import java.time.LocalDate;
import java.time.Period;

public class PersonaService {

    public Persona calcularEdad(int dia, int mes, int anio,String nombre) {
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        int edad = periodo.getYears();

        return new Persona(edad, nombre);
    }
}
