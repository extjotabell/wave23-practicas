package com.calculadoraCalorias.calculadoraCalorias.controller;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoDto;
import com.calculadoraCalorias.calculadoraCalorias.dto.PlatoResponseDto;
import com.calculadoraCalorias.calculadoraCalorias.service.PlatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerCalculadora {
    @Autowired
    PlatoServiceImpl service;

    @GetMapping("/ingredientes")
    public ResponseEntity<?> ingredientesCargados(){
        return new ResponseEntity<>(service.getAllIngredientes(), HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<?> platosCargados(){
        return new ResponseEntity<>(service.getAllPlatos(), HttpStatus.OK);
    }

    @GetMapping("/{name}/{weight}")
    public ResponseEntity<PlatoResponseDto> getPlatos(@PathVariable String name , @PathVariable int weight){
        return new ResponseEntity<>(service.buscarPlato(name, weight), HttpStatus.OK);
    }

    @PostMapping("listaplatos")
    public ResponseEntity<List<PlatoResponseDto>> getListaPlatos(@RequestBody List<PlatoDto> entradaPlato){
        return new ResponseEntity<>(service.buscarListPlatos(entradaPlato), HttpStatus.OK);
    }
}
