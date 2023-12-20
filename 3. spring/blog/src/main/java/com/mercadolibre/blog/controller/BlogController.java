package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.request.EntradaRequestDto;
import com.mercadolibre.blog.service.BlogServiceImpl;
import com.mercadolibre.blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {

    IBlogService service;

    public BlogController(BlogServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/blog")
    public ResponseEntity<?> crearEntrada(@RequestBody EntradaRequestDto request) {
        System.out.println(request);
        return new ResponseEntity<>(service.crearEntrada(request), HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        return new ResponseEntity<>(service.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> buscarTodas() {
        return new ResponseEntity<>(service.buscarTodas(), HttpStatus.OK);
    }

}
