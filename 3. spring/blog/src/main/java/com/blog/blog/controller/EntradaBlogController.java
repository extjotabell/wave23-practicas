package com.blog.blog.controller;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.repository.EntradaBlogRepositoryImp;
import com.blog.blog.services.EntradaBlogServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EntradaBlogController {
    EntradaBlogRepositoryImp entradaBlogRepository = new EntradaBlogRepositoryImp();
    EntradaBlogServiceImp entradaBlogService = new EntradaBlogServiceImp(entradaBlogRepository);

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaBlogDTO entrada){
        return new ResponseEntity<>(entradaBlogService.crearEntrada(entrada), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> obtenerEntradaDeId(@PathVariable Integer id){
        return new ResponseEntity<>(entradaBlogService.buscarEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerTodasLasEntradas(){
        return new ResponseEntity<>(entradaBlogService.todasLasEntradas(), HttpStatus.OK);
    }
}
