package com.bootcamp.deportistas.controller;

import com.bootcamp.deportistas.dto.DeporteDTO;
import com.bootcamp.deportistas.entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class DeportistasRest {

    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDTO>> findSports(){
        return new ResponseEntity<>(DeporteDTO.getDeportes(), HttpStatus.OK);
    }

    @GetMapping("/findSports/{name}")
    public ResponseEntity<?> findSports(@PathVariable String name){
        DeporteDTO deporte = DeporteDTO.getDeportes().stream()
                .filter(deporteDTO -> deporteDTO.getNombre().equals(name))
                .findFirst()
                .orElse(null);

        if (deporte == null){
            return new ResponseEntity<>(new String ("Deporte No Encontrado"), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(deporte, HttpStatus.OK);
    }

    @GetMapping("findSportsPerson")
    public ResponseEntity<List<Persona>> findSportsPerson(){
        return new ResponseEntity<>(Persona.getPersonas(), HttpStatus.OK);
    }

}
