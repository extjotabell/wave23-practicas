package com.meli.sports.controller;


import com.meli.sports.dto.DeporteDTO;
import com.meli.sports.dto.DeporteNivelDTO;
import com.meli.sports.dto.PersonaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SportsController {

    private Map<PersonaDTO, List<DeporteDTO>> deportistas = new HashMap<>();

    private List<DeporteDTO> deportes = new ArrayList<>();

    @GetMapping("/findSports")
    ResponseEntity<List<DeporteDTO>> getSports(){
        this.cargarDatos();
        return new ResponseEntity<>(deportes, HttpStatus.OK);
    }
    @GetMapping("/findSports/{name}")
    ResponseEntity<DeporteNivelDTO> getSports(@PathVariable String name){
        String nivel = deportes.stream().filter(d -> d.getNombre().equals(name)).map(DeporteDTO::getNivel).findFirst().get();
        return new ResponseEntity<>(new DeporteNivelDTO(nivel), HttpStatus.OK);
    }

    @GetMapping("/findSportsPersons")
    ResponseEntity<List<PersonaDTO>> getSportsPersons(){
        List<PersonaDTO> deportesPersonas = new ArrayList<>();

        for (Map.Entry<PersonaDTO, List<DeporteDTO>> entry : deportistas.entrySet()) {
            for (DeporteDTO d : entry.getValue()) {
                PersonaDTO personaDTO = new PersonaDTO(entry.getKey().getNombre(), entry.getKey().getApellido(), d.getNombre());
                deportesPersonas.add(personaDTO);
            }
        }
        return new ResponseEntity<>(deportesPersonas, HttpStatus.OK);
    }


    @PostMapping
    ResponseEntity<DeporteDTO> addSport(@RequestBody DeporteDTO deporte){
        deportes.add(deporte);
        return new ResponseEntity<>(deporte,HttpStatus.CREATED);
    }

    private void cargarDatos(){
        DeporteDTO futbol = new DeporteDTO("Futbol", "Principiante");
        DeporteDTO basket = new DeporteDTO("Basket", "Principiante");
        DeporteDTO tennis = new DeporteDTO("Tennis", "Profesional");
        deportes.addAll(List.of(futbol, basket, tennis));

        PersonaDTO persona = new PersonaDTO("Juan", "Lopez", futbol.getNombre());
        PersonaDTO personaDos= new PersonaDTO("Emilia", "Lopez", tennis.getNombre());

        deportistas.put(persona, List.of(futbol, tennis, basket));
        deportistas.put(personaDos, List.of(tennis, basket));


    }



}
