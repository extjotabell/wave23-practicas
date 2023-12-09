package com.ejercicio.Deportistas.controllers;

import com.ejercicio.Deportistas.dtos.DeporteDTO;
import com.ejercicio.Deportistas.dtos.PersonaDTO;
import com.ejercicio.Deportistas.entities.Deporte;
import com.ejercicio.Deportistas.entities.Persona;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    List<Persona> listaPersonas = new ArrayList<>();
    List<Deporte> listaDeportes = new ArrayList<>();

    @GetMapping("/cargarPersonas")
    public String cargarPersonas(){
        for (int i = 1; i <= 10; i++) {
            String apellido = "Apellido " + i;
            String nombre = "Nombre " + i;
            int edad = i;

            Persona persona = new Persona(nombre, apellido, edad, listaDeportes.get(i - 1));
            listaPersonas.add(persona);
        }
        return "Personas cargados";
    }

    @GetMapping("/cargarDeportes")
    public String cargarDeportes(){
        for (int i = 1; i <= 10; i++) {
            String nombre = "Deporte " + i;
            String nivel = "Nivel " +i;

            Deporte deporte = new Deporte(nombre, nivel);
            listaDeportes.add(deporte);
        }
        return "Deportes cargados";
    }

    @GetMapping("/findSports")
    public List<DeporteDTO> deportes(){
        List<DeporteDTO> deportesDTO = new ArrayList<>();

        for(Deporte deporte : listaDeportes){
            DeporteDTO deporteDTO = new DeporteDTO();
            deporteDTO.setNombre(deporte.getNombre());
            deporteDTO.setNivel(deporte.getNivel());

            deportesDTO.add(deporteDTO);
        }

        return deportesDTO;
    }

    @GetMapping("findSports/{name}")
    public ResponseEntity<String> buscarDeporte(@PathVariable String name){
        Optional<Deporte> result = listaDeportes.stream().filter(x -> x.getNombre().equals(name)).findFirst();

        return result.map(deporte -> new ResponseEntity<>("El nivel del deporte " + name + " es " + deporte.getNivel(),
                HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("No se encontro ningun deporte con ese nombre", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonaDTO>> buscarPersonaDeporte(){
        List<PersonaDTO> listaPersonasDTO = new ArrayList<>();

        for(Persona persona : listaPersonas){
            PersonaDTO personaDTO = new PersonaDTO();

            personaDTO.setNombre(persona.getNombre());
            personaDTO.setApellido(persona.getApellido());
            personaDTO.setNombreDeporte(persona.getDeporte().getNombre());

            listaPersonasDTO.add(personaDTO);
        }

        return new ResponseEntity<>(listaPersonasDTO, HttpStatus.OK);
    }
}
