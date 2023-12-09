package com.ejercicio.calculoEdad.Controllers;

import com.ejercicio.calculoEdad.entities.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/api")
public class ControllerEdad {
    @GetMapping(path = "/{mes}/{dia}/{anio}")
    public Persona getFecha(@PathVariable int dia,
                           @PathVariable int mes,
                           @PathVariable int anio){
        try {
            LocalDate fechaRecibida = LocalDate.of(anio, mes, dia);

            LocalDate fechaActual = LocalDate.now();

            Period diferencia = Period.between(fechaRecibida, fechaActual);

            Persona persona = new Persona("Matias");
            persona.setEdad(Integer.parseInt(diferencia.getYears()+""));
            return persona;
        }catch (DateTimeException e){
            //return e.getMessage();
            return null;
        }
    }


}
