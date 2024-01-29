package com.example.ejerciciocovid19.controllers;

import com.example.ejerciciocovid19.dto.PersonasSintomasDTO;
import com.example.ejerciciocovid19.dto.SintomaDTO;
import com.example.ejerciciocovid19.services.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/")
public class SintomasController {

    @Autowired
    private CovidService covidService;
    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return ResponseEntity.ok().body(covidService.generarListaSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> buscarSintoma(@PathVariable String name){
        SintomaDTO sintoma = covidService.buscarSintomaPorNombre(name);
        return ResponseEntity.ok().body(sintoma);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonasSintomasDTO>> listarPersonasEnRiesgo(){
        return ResponseEntity.ok().body(covidService.generarListaPersonasRiesgoYSintomas());
    }




}