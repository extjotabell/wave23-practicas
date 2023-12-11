package com.bootcamp.edad.services;

import com.bootcamp.edad.entity.Persona;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EdadService {

    public Persona crearPersona(Integer dia, Integer mes, Integer anio, String nombre){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Persona persona = new Persona(nombre, fechaNacimiento);
        return persona;
    }

    public Persona obtenerEdad(Integer dia, Integer mes, Integer anio){
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Persona persona = new Persona(fechaNacimiento);
        return persona;
    }

}
