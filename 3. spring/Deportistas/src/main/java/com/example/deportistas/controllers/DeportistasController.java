package com.example.deportistas.controllers;


import com.example.deportistas.dto.DeporteDto;
import com.example.deportistas.dto.ListaDto;
import com.example.deportistas.dto.PersonaDeporteDto;
import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;
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
@RequestMapping("api")
public class DeportistasController {

    Deporte deporte1 = new Deporte("Natacion", "Inicial");
    Deporte deporte2 = new Deporte("Tenis", "Avanzado");
    Deporte deporte3 = new Deporte("Basket", "Intermedio");

    List<Deporte> deportes = new ArrayList<>(List.of(deporte1,deporte2,deporte3));

    Persona persona1 = new Persona("Nico", "Apellido", 22, null);
    Persona persona2 = new Persona("Marco", "Apellido2", 36, deporte1);
    Persona persona3 = new Persona("Lolo", "Apellido3", 12, deporte3);

    List<Persona> personas = new ArrayList<>(List.of(persona1,persona2,persona3));



    @GetMapping("/findSports")
    ResponseEntity<?> findSports(){
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }

    @GetMapping("/findSport/{name}")
    ResponseEntity<?> findSports(@PathVariable String name){

        Deporte deporte = deportes.stream()
                .filter(d -> d.getNombre().equals(name)).findFirst().orElse(null);

        if(deporte == null){
            return new ResponseEntity<>("No se encontro el deporte", HttpStatus.NOT_FOUND);
        }

        DeporteDto dto = new DeporteDto(deporte.getNivel());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<?> findSportsPersons(){
        ListaDto deportistas = new ListaDto();
        for (Persona p: personas
             ) {
            if(p.getDeporte() != null){
                String nombreCompleto = p.getNombre()+ " " + p.getApellido();
                PersonaDeporteDto deportista = new PersonaDeporteDto(nombreCompleto,p.getDeporte().getNombre());
                deportistas.getListaDto().add(deportista);

            }
        }

        return new ResponseEntity<>(deportistas, HttpStatus.OK);

    }

}
