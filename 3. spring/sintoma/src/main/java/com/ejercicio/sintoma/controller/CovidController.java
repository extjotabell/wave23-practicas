package com.ejercicio.sintoma.controller;

import com.ejercicio.sintoma.dto.PersonaDto;
import com.ejercicio.sintoma.dto.SintomaDto;
import com.ejercicio.sintoma.models.Persona;
import com.ejercicio.sintoma.models.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid/")
public class CovidController {
    private final List<Persona> personas = List.of(
            new Persona("Juan", "Perez", 40,1),
            new Persona("Diana", "Perez", 60,2),
            new Persona("Rosa", "Martin", 63,3)
    );
    private final List<Sintoma> sintomas = List.of(
            new Sintoma("1", "tos","media"),
            new Sintoma("2", "diarrea","alta"),
            new Sintoma("3", "cuerpo cortado","alta")
    );
    
 private List<PersonaDto> contagiados = new ArrayList<>();

    @PostMapping("/agregarEnfermo")
    public ResponseEntity<?> agregarContagiado(@RequestParam int idPersona ,@RequestParam String nombre){
       Optional<PersonaDto> enfermo = personas.stream().
                filter(persona -> persona.getIdPersona()==idPersona).
                map(persona -> new PersonaDto(persona.getNombre(),persona.getApellido(),nombre, persona.getEdad())).
                findFirst();
        contagiados.add(enfermo.get());
        return ResponseEntity.ok().body("Nueva persona contagiada");
    }

    
    @GetMapping("/findSymptoms")
    private ResponseEntity<?> encuentraSintomas(){
        List<SintomaDto> sintomaDtos = sintomas.stream().
                map(sintoma -> new SintomaDto(sintoma.getNombre(),sintoma.getGravedad())).
                toList();
        return ResponseEntity.ok().body(sintomaDtos);
    }
     @GetMapping("/findSymptom/{name}")
     private ResponseEntity<?> encontrarSintoma(@PathVariable String name){
        Optional<SintomaDto> sintoma = sintomas.stream().
                filter(sintoma1 -> sintoma1.getNombre().equals(name)).
                map(sintoma1 -> new SintomaDto(sintoma1.getNombre(),sintoma1.getGravedad())).
                findFirst();
        return ResponseEntity.ok().body(sintoma);
     }
     @GetMapping("/findRiskPerson")
     private ResponseEntity<?> personaRiesgo(){
        List<PersonaDto> personaDtos = contagiados.stream().
                filter(personaDto -> personaDto.getEdad()>= 60).
                toList();
        return ResponseEntity.ok().body(personaDtos);
     }
}
