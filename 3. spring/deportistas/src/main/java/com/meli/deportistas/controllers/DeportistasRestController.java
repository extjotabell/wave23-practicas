package com.meli.deportistas.controllers;

import com.meli.deportistas.entities.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeportistasRestController {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports() {
        return new ResponseEntity<>(
            DeporteDTO.getDeportes(),
            HttpStatus.OK
        );
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> findSport(@PathVariable String name) {
        DeporteDTO deporte = DeporteDTO.getDeportes().stream()
            .filter(d -> d.getNombre().equals(name))
            .findFirst()
            .orElse(null);

        if (deporte == null) return new ResponseEntity<>(
                new MensajeDTO("Sport not found"),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(deporte, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<Persona>> findSportsPersons() {
        return new ResponseEntity<>(
            Persona.getPersonas(),
            HttpStatus.OK
        );
    }

    @PostMapping("/addSport")
    public ResponseEntity<?> addSport(@RequestBody Deporte deporte) {
        // Check if sport already exists
        DeporteDTO deporteExist = DeporteDTO.getDeportes().stream()
            .filter(d -> d.getNombre().equals(deporte.getNombre()))
            .findFirst()
            .orElse(null);

        if (deporteExist != null) return new ResponseEntity<>(
            new MensajeDTO("Sport already exists"),
            HttpStatus.CONFLICT
        );

        DeporteDTO deporteDTO = new DeporteDTO(
            deporte.getNombre(),
            deporte.getNivel()
        );

        return new ResponseEntity<>(deporteDTO, HttpStatus.CREATED);
    }

    @PostMapping("/addSportPerson")
    public ResponseEntity<?> addSportPerson(@RequestBody PersonaDTO personaDTO) {
        // Check if sport exists
        DeporteDTO deporteDTO = DeporteDTO.getDeportes().stream()
            .filter(d -> d.getNombre().equals(personaDTO.getDeporte()))
            .findFirst()
            .orElse(null);

        if (deporteDTO == null) return new ResponseEntity<>(
            new MensajeDTO("Sport not found"),
            HttpStatus.NOT_FOUND
        );

        // Check if person already exists
        Persona personaExist = Persona.getPersonas().stream()
            .filter(p -> p.getNombre().equals(personaDTO.getNombre()) && p.getApellido().equals(personaDTO.getApellido()))
            .findFirst()
            .orElse(null);

        if (personaExist != null) return new ResponseEntity<>(
            new MensajeDTO("Person already exists"),
            HttpStatus.CONFLICT
        );

        // If all is ok, add person to list and return original object

        new Persona(
            personaDTO.getNombre(),
            personaDTO.getApellido(),
            personaDTO.getEdad(),
            personaDTO.getDeporte()
        );

        return new ResponseEntity<>(personaDTO, HttpStatus.CREATED);
    }
}
