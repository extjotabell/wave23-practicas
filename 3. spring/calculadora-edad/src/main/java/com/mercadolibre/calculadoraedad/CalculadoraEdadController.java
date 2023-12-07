package com.mercadolibre.calculadoraedad;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraEdadController {

    @GetMapping(path = "/{day}/{month}/{year}")
    public String getPersona(@PathVariable int day, @PathVariable int month, @PathVariable int year,
                             @RequestParam String nombre, @RequestParam String apellido) {
        Persona persona = new Persona(nombre, apellido, year, month, day);
        return persona.toString();
    }
}
