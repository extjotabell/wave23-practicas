package com.spring.covid19.controller;

import com.spring.covid19.dtos.AllPersonaResponseDto;
import com.spring.covid19.dtos.PersonaDto;
import com.spring.covid19.dtos.SintomasDto;
import com.spring.covid19.entities.Persona;
import com.spring.covid19.entities.Sintoma;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class CovidController {

    List<Sintoma> sintomas;
    List<Persona> personas;

    public CovidController() {
        this.sintomas = new ArrayList<>();
        sintomas.add(new Sintoma("cod01", "Nombre 1", "bajo"));
        sintomas.add(new Sintoma("cod02", "Nombre 2", "medio"));
        sintomas.add(new Sintoma("cod03", "Nombre 3", "bajo"));
        sintomas.add(new Sintoma("cod04", "Nombre 4", "alto"));
        sintomas.add(new Sintoma("cod05", "Nombre 5", "medio"));

        this.personas = new ArrayList<>();
        personas.add(new Persona(
                61,
                "nombre1",
                "apellido1",
                new ArrayList<>()));
        personas.add(new Persona(
                80,
                "nombre2",
                "apellido2",
                List.of(new Sintoma(
                                "cod01",
                                "Nombre 1",
                                "bajo"),
                        new Sintoma(
                                "cod03",
                                "Nombre 3",
                                "bajo"))));
        personas.add(new Persona(
                60,
                "nombre3",
                "apellido3",
                List.of(new Sintoma(
                                "cod01",
                                "Nombre 1",
                                "bajo"),
                        new Sintoma(
                                "cod03",
                                "Nombre 3",
                                "bajo"))));
        personas.add(new Persona(
                59,
                "nombre4",
                "apellido4",
                List.of(new Sintoma(
                                "cod01",
                                "Nombre 1",
                                "bajo"),
                        new Sintoma(
                                "cod03",
                                "Nombre 3",
                                "bajo"))));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> allSymptom() {
        List<SintomasDto> allSintomaDtos = new ArrayList<>();

        sintomas.forEach(x -> allSintomaDtos.add(new SintomasDto(x.getNombre(), x.getNivel_de_gravedad())));

        return ResponseEntity.ok(allSintomaDtos);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptomByName(@PathVariable String name) {

        for (Sintoma sint : sintomas) {
            if (sint.getNombre().equals(name)) {
                return ResponseEntity.ok(new SintomasDto(sint.getNombre(), sint.getNivel_de_gravedad()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson() {
        List<PersonaDto> personaDtos = new ArrayList<>();
        for (Persona p : personas) {
            if (!p.getSintomas().isEmpty() && p.getEdad() > 60) {
                personaDtos.add(new PersonaDto(p.getNombre(), p.getApellido()));
            }
        }
        AllPersonaResponseDto response = new AllPersonaResponseDto(personaDtos);
        return ResponseEntity.ok(response);
    }
}
