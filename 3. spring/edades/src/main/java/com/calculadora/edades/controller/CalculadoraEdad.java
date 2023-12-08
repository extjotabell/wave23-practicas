package com.calculadora.edades.controller;
import com.calculadora.edades.entities.Persona;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraEdad {
    private final List<Persona> personas = new ArrayList<>();
    @GetMapping("/listar")
    public List<Persona> obtenerListaPersonas(){
        return personas;
    }

    @PostMapping("/alta")
    public String altaPersona(@RequestBody Persona persona){
        personas.add(persona);
        return "Se agregó con exito";
    }

    public Optional<Persona> buscarPersona(String id){
        Optional<Persona> encontrado = personas.stream().filter(persona -> persona.getId().equals(id)).findFirst();
        return encontrado;
    }
    @GetMapping("/edad/{id}")
    public String calcularEdad(@PathVariable String id){
        Persona encontrado = buscarPersona(id).get();
        LocalDate nacimiento = encontrado.getNacimiento().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        Period period = Period.between(nacimiento,LocalDate.now());
        return "La Persona: "+encontrado.toString()+" tiene"+ period.getYears() +
                " años "+period.getMonths() +
                "meses "+ period.getDays()+" dias";

    }

}
