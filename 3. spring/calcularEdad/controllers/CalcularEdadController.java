package com.example.calcularEdad.controllers;

import com.example.calcularEdad.entities.Persona;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.*;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("edad")
public class CalcularEdadController {

    @GetMapping("/{name}/{day}/{month}/{year}")
    public Persona calcularEdad(
            @PathVariable String name,
            @PathVariable String day,
            @PathVariable String month,
            @PathVariable String year
    ){

        if(day.length() == 1)
            day = "0" + day;

        if(month.length() == 1)
            month = "0" + month;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(day + "/" + month + "/" + year, fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNac, ahora);

        Persona p = new Persona(name, periodo.getYears());

        return p;
    }
}
