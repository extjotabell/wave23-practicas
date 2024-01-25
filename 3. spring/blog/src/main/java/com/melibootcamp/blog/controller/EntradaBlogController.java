package com.melibootcamp.blog.controller;

import com.melibootcamp.blog.dto.EntradaBlogDTO;
import com.melibootcamp.blog.repository.EntradaBlogRepository;
import com.melibootcamp.blog.services.EntradaBlogServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EntradaBlogController {
    EntradaBlogRepository entradaBlogRepository = new EntradaBlogRepository();
    EntradaBlogServiceImpl entradaBlogService = new EntradaBlogServiceImpl(entradaBlogRepository);

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaBlogDTO entrada){
        return new ResponseEntity<>(entradaBlogService.crearEntrada(entrada), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> obtenerEntradaDeId(@PathVariable String id){
        return new ResponseEntity<>(entradaBlogService.buscarEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerTodasLasEntradas(){
        return new ResponseEntity<>(entradaBlogService.todasLasEntradas(), HttpStatus.OK);
    }
}
