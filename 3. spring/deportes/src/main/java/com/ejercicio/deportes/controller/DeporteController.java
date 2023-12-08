package com.ejercicio.deportes.controller;

import com.ejercicio.deportes.dto.DeporteDto;
import com.ejercicio.deportes.dto.PersonaDto;
import com.ejercicio.deportes.models.Deporte;
import com.ejercicio.deportes.models.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DeporteController {

    private final List<Deporte> deportes = List.of(
            new Deporte("NATACION", "PRINCIPIANTE"),
            new Deporte("FUTBOL", "AVANZADO"),
            new Deporte("DANZA", "INTERMEDIO")
    );
    private final List<Persona> personas =List.of(
            new Persona("Juan", "Perez", 40, deportes.get(1)),
            new Persona("Maria", "Gonzales", 34, deportes.get(0))
    );

    @GetMapping("/findSports")
    public ResponseEntity<?> listaDeportes(){
        List<DeporteDto> deporteDto= deportes.stream().map(deporte -> new DeporteDto(deporte.getNombre(),deporte.getNivel())).toList();
        return new ResponseEntity<>(deporteDto, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<?> encontrarDeporte(@PathVariable String name){
        Optional<DeporteDto> deporteDto= deportes.stream().filter(deporte -> deporte.getNombre().equals(name)).map(deporte -> new DeporteDto(deporte.getNombre(), deporte.getNivel())).findFirst();
        return ResponseEntity.status(200).body(deporteDto);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> listaDeportistas(){
        List<PersonaDto> deportistas= personas.stream().map(persona -> new PersonaDto(persona.getNombre(), persona.getApellido(),persona.getDeporte().getNombre())).toList();
        return ResponseEntity.status(200).body(deportistas);
    }



}
