package com.spring.deportistas.controllers;

import com.spring.deportistas.dto.*;
import com.spring.deportistas.entities.Deporte;
import com.spring.deportistas.entities.Persona;
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
@RequestMapping("api/Deportista")
public class DeportistasController {

    List<Deporte> deports;

    Map<String, Persona> deportistas;

    public DeportistasController() {
        deports = new ArrayList<>();
        deports.add(new Deporte("Handball", "Bajo"));
        deports.add(new Deporte("Football", "Medio"));
        deports.add(new Deporte("Volleyball", "Alto"));

        deportistas = new HashMap<>();
        deportistas.put("Handball", new Persona("Andres", "Limpio", 30));
        deportistas.put("Football", new Persona("Alejandro", "Diaz", 33));
        deportistas.put("Volleyball", new Persona("Lejo", "Lidi", 34));
    }

    @GetMapping("/findSports")
    public ResponseEntity<AllDeporteResponseDto> allSports() {
        List<DeporteDto> deportsDto = new ArrayList<>();
        for (Deporte d : deports) {
            deportsDto.add(new DeporteDto(d.getNivel(), d.getNombre()));
        }

        AllDeporteResponseDto response = new AllDeporteResponseDto(deportsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> allSportsByName(@PathVariable String name) {
        DeporteDto response = new DeporteDto();

        for (Deporte d : deports) {
            if (d.getNombre().equals(name)) {
                return ResponseEntity.ok(new DeporteDto(d.getNivel(), d.getNombre()));
            }
        }

        return new ResponseEntity<ResponseDto>( new ResponseDto("Deporte no encontrado"), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> allSportsPerson() {
        List<DeportistaDto> deportistasDto = new ArrayList<>();

        deportistas.forEach((key, persona) -> deportistasDto
                .add(new DeportistaDto(persona.getNombre(), persona.getApellido(), key)));

        AllDeportistaResponseDto response = new AllDeportistaResponseDto(deportistasDto);
        return ResponseEntity.ok(response);
    }
}
