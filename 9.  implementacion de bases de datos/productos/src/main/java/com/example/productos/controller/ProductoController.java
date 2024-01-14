package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
public class ProductoController {
    @Autowired
    ProductoService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Producto producto){
        return ResponseEntity.ok(service.save(producto));
    }

    @PutMapping("/modify")
    public ResponseEntity<?> modify(@RequestBody Producto producto){
        return ResponseEntity.ok(service.modify(producto));
    }
}
