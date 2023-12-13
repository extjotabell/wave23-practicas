package com.wave.strarWars.controller;

import com.wave.strarWars.dto.request.PersonajeDto;
import com.wave.strarWars.entity.Personaje;
import com.wave.strarWars.service.PersonajeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class PersonajeController {

  @Autowired
    PersonajeServiceImpl service;

  @GetMapping("/personajes")
    public ResponseEntity<?> obtenerPersonajes(){

      return new ResponseEntity<>(service.findAllpersonajes(), HttpStatus.OK);
  }

  @GetMapping("/personaje/{nombre}")
  public ResponseEntity<?> obtenerPersonajesPorNombre(@PathVariable String nombre){

    return new ResponseEntity<>(service.findPersonajesByName(nombre), HttpStatus.OK);
  }

  @PostMapping("/cargar")
    public ResponseEntity<?> cargarPersonaje(@RequestBody Personaje personaje){
      return new ResponseEntity<>(service.savePersonaje(personaje),HttpStatus.OK);
    }

}


