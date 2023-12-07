package com.edadPersona.obtenerEdad.controllers;

import com.edadPersona.obtenerEdad.entities.Persona;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@RestController
public class ObtenerEdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        Period periodo = Period.between(fechaNacimiento, fechaHoy);

        return periodo.getYears();
    }

    @PostMapping("/agregarPersona")
    @ResponseBody
    public Persona agregarPersona(@RequestBody Persona persona) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse(persona.getFechaNac(), formatter);

        LocalDate fechaActual = LocalDate.now();

        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        if (fechaNacimiento.getDayOfYear() > fechaActual.getDayOfYear()) {
            edad--;
        }

        persona.setEdad(edad);

        return persona;
    }

}
