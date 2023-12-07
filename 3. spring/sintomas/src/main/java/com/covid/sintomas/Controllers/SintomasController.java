package com.covid.sintomas.Controllers;

import com.covid.sintomas.DTOS.PersonasSintomasDTO;
import com.covid.sintomas.DTOS.SintomaDTO;
import com.covid.sintomas.Entities.Sintoma;
import com.covid.sintomas.Services.CovidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class SintomasController {

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SintomaDTO>> listarSintomas(){
        return ResponseEntity.ok().body(CovidService.generarListaSintomas());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SintomaDTO> buscarSintoma(@PathVariable String name){
        SintomaDTO sintoma = CovidService.buscarSintomaPorNombre(name);
        return ResponseEntity.ok().body(sintoma);
    }

    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<PersonasSintomasDTO>> listarPersonasEnRiesgo(){
        return ResponseEntity.ok().body(CovidService.generarListaPersonasRiesgoYSintomas());
    }




}
