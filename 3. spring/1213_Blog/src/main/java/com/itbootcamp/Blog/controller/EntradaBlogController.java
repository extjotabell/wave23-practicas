package com.itbootcamp.Blog.controller;

import com.itbootcamp.Blog.dto.EntradaBlogDto;
import com.itbootcamp.Blog.service.IEntradaBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entradaBlog")
public class EntradaBlogController {
    @Autowired
    IEntradaBlogService entradaBlogServiceRepository;

    @PostMapping
    public ResponseEntity<?> agregarBlog(@RequestBody EntradaBlogDto nuevaEntradaDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(entradaBlogServiceRepository.agregarEntradaBlog(nuevaEntradaDto));
    }

    @GetMapping
    public ResponseEntity<?> mostrarTodos(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(entradaBlogServiceRepository.mostrarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(entradaBlogServiceRepository.buscarPorId(id));
    }


}
