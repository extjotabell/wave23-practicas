package com.meli.ejercicioDeportistas.controller;

import com.meli.ejercicioDeportistas.model.dto.DeporteListResponseDTO;
import com.meli.ejercicioDeportistas.model.dto.PersonaListResponseDTO;
import com.meli.ejercicioDeportistas.service.DeporteService;
import com.meli.ejercicioDeportistas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deporteAPI")
public class ApplicationController {
    @Autowired
    private DeporteService deporteService;
    @Autowired
    private PersonaService personaService;

    @GetMapping("/findSports")
    public ResponseEntity<?> getAllDeportes(){
        DeporteListResponseDTO res = deporteService.getAllDeportes();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/findSport/{nombre}")
    public ResponseEntity<?> getDeporteByName(@PathVariable String nombre){
        DeporteListResponseDTO res = deporteService.getDeporteByName(nombre);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @GetMapping("/findSportsPeople")
    public ResponseEntity<?> getSportPeople(){
        PersonaListResponseDTO res = personaService.getAllPeople();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
