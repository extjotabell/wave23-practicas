package com.bootcampmeli.edad.service;

import com.bootcampmeli.edad.model.Persona;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EdadService {

    LocalDate hoy = LocalDate.now();
    LocalDate parametro;

    public Integer getEdad(int dia, int mes, int anio){
        parametro = LocalDate.of(anio, mes, dia);
        return Math.toIntExact(ChronoUnit.YEARS.between(parametro, hoy));
    };

    public String getMensajePersonalizado(Integer edad, String nombre, String apellido){
        Persona persona = new Persona(edad, nombre, apellido);
        return persona.toString();
    };
}
