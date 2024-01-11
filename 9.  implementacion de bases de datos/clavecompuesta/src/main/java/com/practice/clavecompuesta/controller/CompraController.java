package com.practice.clavecompuesta.controller;

import com.practice.clavecompuesta.dto.CompraDTO;
import com.practice.clavecompuesta.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompraController {
    @Autowired
    private CompraService compraService;

    @PostMapping("/compras/create")
    public ResponseEntity<?> createCompra(@RequestBody CompraDTO compraDTO){
        return new ResponseEntity<>(compraService.createCompra(compraDTO), HttpStatus.CREATED);
    }
}
