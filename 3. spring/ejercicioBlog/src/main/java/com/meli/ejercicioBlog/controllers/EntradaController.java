package com.meli.ejercicioBlog.controllers;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
public class EntradaController {
    @Autowired
    private EntradaService service;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EntradaBlogCreacionRequestDTO entradaDto){
        return new ResponseEntity<>(service.crear(entradaDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> find(@PathVariable String id){
        return ResponseEntity.ok(service.find(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }
}
