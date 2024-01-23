package com.spring.deportista.controller;

import com.spring.deportista.dto.*;
import com.spring.deportista.entity.Deporte;
import com.spring.deportista.entity.Persona;
import org.springframework.context.annotation.Bean;
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
@RequestMapping("api/deportista")
public class DeportistaController {

    List<Deporte> sports = new ArrayList<>();
    List<Persona> persons = new ArrayList<>();

    @Bean
    private void addInformation() {
        Deporte sport1 = new Deporte("Patinaje", "Alto");
        Deporte sport2 = new Deporte("Basketball", "Medio");
        Deporte sport3 = new Deporte("Natacion", "Bajo");
        sports.add(sport1);
        sports.add(sport2);
        sports.add(sport3);

        persons.add(new Persona("Camila", "Mamani", 26, sport2));
        persons.add(new Persona("Pepe", "Lopez", 30, sport1));

    }


    @GetMapping("/findSports")
    public ResponseEntity<AllDeporteResponseDto> allSports() {
        List<DeporteDto> deportsDto = new ArrayList<>();
        for (Deporte d : sports) {
            deportsDto.add(new DeporteDto(d.getNivel(), d.getNombre()));
        }
        AllDeporteResponseDto response = new AllDeporteResponseDto(deportsDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> allSportsByName(@PathVariable String name) {
        for (Deporte d : sports) {
            if (d.getNombre().equals(name)) {
                return ResponseEntity.ok(new DeporteDto(d.getNivel(), d.getNombre()));
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<?> allSportsPerson() {
        List<DeportistaDto> deportistasDto = new ArrayList<>();

        persons.forEach(p -> deportistasDto
                .add(new DeportistaDto(p.getNombre(), p.getApellido(), p.getDeporte().getNombre())));

        AllDeportistaResponseDto response = new AllDeportistaResponseDto(deportistasDto);
        return ResponseEntity.ok(response);
    }
}
