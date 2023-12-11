package com.example.covid19.controller;

import com.example.covid19.dto.PersonaDTO;
import com.example.covid19.dto.PersonaRiesgoDTO;
import com.example.covid19.model.Persona;
import com.example.covid19.model.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {


    @PostMapping
    public ResponseEntity<PersonaDTO> agregarPersona(@RequestBody PersonaDTO nuevaPersonaDTO){
        Persona nuevaPersona = new Persona(nuevaPersonaDTO.getId(), nuevaPersonaDTO.getNombre(), nuevaPersonaDTO.getApellido(), nuevaPersonaDTO.getEdad());
        Persona.agregarPersona(nuevaPersona);
        return new ResponseEntity<>(nuevaPersonaDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> encontrarTodasPersonas(){
        List<PersonaDTO> personasDTO = new ArrayList<>();
        for(Persona persona : Persona.getListaPersonas()){
            personasDTO.add(new PersonaDTO(persona.getId(), persona.getNombre(), persona.getApellido(), persona.getEdad()));
        }
        return ResponseEntity.ok(personasDTO);
    }

    @GetMapping("/enRiesgo")
    public ResponseEntity<List<PersonaRiesgoDTO>> encontrarPersonasEnRiesgo(){

        List<PersonaRiesgoDTO> personasEnRiesgo = new ArrayList<>();

        for(Persona persona : Persona.getListaPersonas()){
            if(persona.getEdad() > 60){
                personasEnRiesgo.add(new PersonaRiesgoDTO(
                        persona.getId(),
                        persona.getNombre(),
                        persona.getApellido(),
                        persona.getEdad(),
                        Sintoma.getListaSintomas()
                ));
            }
        }

        return ResponseEntity.ok().body(personasEnRiesgo);
    }

}
