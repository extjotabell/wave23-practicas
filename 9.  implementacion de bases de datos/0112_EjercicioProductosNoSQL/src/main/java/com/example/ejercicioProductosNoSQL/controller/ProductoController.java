package com.example.ejercicioProductosNoSQL.controller;

import com.example.ejercicioProductosNoSQL.dto.ProductoDto;
import com.example.ejercicioProductosNoSQL.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductoDto productoDto){
        return ResponseEntity.ok(productoService.save(productoDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

}
