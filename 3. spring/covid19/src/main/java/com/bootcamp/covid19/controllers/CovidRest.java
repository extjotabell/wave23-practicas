package com.bootcamp.covid19.controllers;

import com.bootcamp.covid19.dto.PersonaRiesgoDTO;
import com.bootcamp.covid19.dto.SintomaDTO;
import com.bootcamp.covid19.entities.Persona;
import com.bootcamp.covid19.entities.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/covid19")
public class CovidRest {

    private static List<Persona> personas = new ArrayList<>(List.of(
        new Persona(1, 30, "Lucas", "Salerno"),
            new Persona(2, 63, "Juan", "Perez"),
            new Persona(3, 26, "Maria", "Fernandez"),
            new Persona(4, 58, "Pedro", "Romero"),
            new Persona(5, 74, "Susana", "Colombo")
    ));

    private static List<Sintoma> sintomas = new ArrayList<>(List.of(
            new Sintoma(1, 1, "Tos"),
            new Sintoma(2, 2, "Fiebre"),
            new Sintoma(3, 2, "Cefalea"),
            new Sintoma(4, 3, "Dolor de Garganta"),
            new Sintoma(5, 4, "Perdida de Olfato"),
            new Sintoma(6, 4, "Perdida de Gusto")
    ));

    private static Map<Persona, Sintoma> casos = new HashMap<>(Map.of(
            personas.get(0), sintomas.get(4),
            personas.get(1), sintomas.get(5),
            personas.get(2), sintomas.get(0),
            personas.get(3), sintomas.get(2),
            personas.get(4), sintomas.get(2)
    ));

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> findSymptom(){
        List<SintomaDTO> sintomasDTO = sintomas.stream()
                .map(sintoma -> {return new SintomaDTO(sintoma.getNombre(), sintoma.getNivelGravedad());})
                .toList();

        return new ResponseEntity<>(sintomasDTO, HttpStatus.OK);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> findSymptom(@PathVariable String name){
        Sintoma sintoma = sintomas.stream()
                .filter(sintoma_1 -> sintoma_1.getNombre().equals(name))
                .findFirst()
                .orElse(null);

        if (sintoma == null){
            return new ResponseEntity<>(new String("No se encontro el Sintoma"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new SintomaDTO(sintoma.getNombre(), sintoma.getNivelGravedad()), HttpStatus.OK);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> findRiskPerson(){
        List<PersonaRiesgoDTO> personasRiesgo = new ArrayList<>();

        casos.forEach((persona, sintoma) -> {
            if (persona.getEdad() > 60){
                personasRiesgo.add(new PersonaRiesgoDTO(persona.getNombre() + " " + persona.getApellido(), persona.getEdad(), sintoma.getNombre(), sintoma.getNivelGravedad()));
            }
        });

        if (personasRiesgo.size() <= 0){
            return new ResponseEntity<>(new String("No se han encontrado casos de riesgo"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personasRiesgo, HttpStatus.OK);
    }

}
