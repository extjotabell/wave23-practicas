package com.example.deportistas.controllers;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.dto.DeportesDTO;
import com.example.deportistas.dto.PersonasDTO;
import com.example.deportistas.services.DeportistasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DeportistasController {

    private final DeportistasService deportistasService;

    public DeportistasController(DeportistasService deportistasService) {
        this.deportistasService = deportistasService;
    }

    @GetMapping("/findSports")
    public ResponseEntity<DeportesDTO> findSports() {
        return ResponseEntity.ok(deportistasService.getDeportes());
    }

    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<DeporteDTO> findSport(@PathVariable String nombre) {
        Optional<DeporteDTO> deporte = deportistasService.getDeporte(nombre);
        return deporte.map(ResponseEntity::ok).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<PersonasDTO> findSportsPersons() {
        return ResponseEntity.ok(deportistasService.getPersonas());
    }

}
