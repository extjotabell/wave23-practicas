package com.edadpersona.edadpersona.services;
import com.edadpersona.edadpersona.entities.Persona;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class DataServices {
    public Persona crearPersona(Integer dia, Integer mes,Integer anio, String nombre){
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        Persona persona = new Persona(nombre,fechaNacimiento);
        return persona;
    }

    public Persona obtenerEdad(Integer dia, Integer mes,Integer anio){
        LocalDate fechaNacimiento = LocalDate.of(anio,mes,dia);
        Persona persona = new Persona(fechaNacimiento);
        return persona;
    }
}
