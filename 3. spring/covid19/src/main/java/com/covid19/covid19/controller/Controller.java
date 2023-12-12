package com.covid19.covid19.controller;

import com.covid19.covid19.dto.PersonaDTO;
import com.covid19.covid19.dto.ResponsePersonaDTO;
import com.covid19.covid19.dto.SintomaDTO;
import com.covid19.covid19.model.Persona;
import com.covid19.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sintomas")

public class Controller {

    List<Sintoma> sintomas;
    List<Persona> personas;

    public Controller() {
        this.sintomas = new ArrayList<>();
        Sintoma sintoma1 = new Sintoma(1, "Toz", "bajo");
        Sintoma sintoma2 = new Sintoma(2, "Fiebre", "medio");
        Sintoma sintoma3 = new Sintoma(3, "Dolor Cabeza", "bajo");
        Sintoma sintoma4 = new Sintoma(4, "Dolor Muscular", "alto");
        Sintoma sintoma5 = new Sintoma(5, "Vomito", "medio");
        sintomas.add(sintoma1);
        sintomas.add(sintoma2);
        sintomas.add(sintoma3);
        sintomas.add(sintoma4);
        sintomas.add(sintoma5);

        this.personas = new ArrayList<>();
        personas.add(new Persona(1,"Greta", "Vargas", 20, new ArrayList<>(Arrays.asList(sintoma1, sintoma3))));
        personas.add(new Persona(2,"Vicky", "Silva", 20, new ArrayList<>(Arrays.asList(sintoma4,sintoma5,sintoma2))));
        personas.add(new Persona(3,"Camina", "Reyes", 65, new ArrayList<>(Arrays.asList(sintoma1,sintoma2,sintoma3))));
        personas.add(new Persona(4,"Fernanda", "Molina", 62, new ArrayList<>(Arrays.asList(sintoma4,sintoma5,sintoma3))));
    }

    @GetMapping("/findSymptom")
    public ResponseEntity<?> getSintomas() {
        List<SintomaDTO> sintimasLista = new ArrayList<>();
        sintomas.forEach(x -> sintimasLista.add(new SintomaDTO(x.getNombre(), x.getNivelGravedad())));
        return ResponseEntity.ok(sintimasLista);
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<?> getSintomaNombre(@PathVariable String name) {
        for (Sintoma sintoma : sintomas) {
            if (sintoma.getNombre().equals(name)) {
                return ResponseEntity.ok(new SintomaDTO(sintoma.getNombre(), sintoma.getNivelGravedad()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<?> getfindRiskPerson() {
        if (personas != null) {
            List<PersonaDTO> personaDtos = new ArrayList<>();
            for (Persona persona : personas) {
                if (persona.getSintomas() != null && !persona.getSintomas().isEmpty() && persona.getEdad() > 60) {
                    personaDtos.add(new PersonaDTO(persona.getNombre(), persona.getApellido()));
                }
            }
            ResponsePersonaDTO response = new ResponsePersonaDTO(personaDtos);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("La lista de personas es nula.");
        }
    }
}
