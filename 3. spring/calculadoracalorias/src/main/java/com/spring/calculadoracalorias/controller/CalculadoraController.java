package com.spring.calculadoracalorias.controller;

import com.spring.calculadoracalorias.dto.PlatoDto;
import com.spring.calculadoracalorias.service.CalculadoraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/CalculadoraCalorias")
public class CalculadoraController {

    @Autowired
    private CalculadoraServiceImpl service;

    @GetMapping("/informeCalorico/{nombre}")
    public ResponseEntity<PlatoDto> informeCalorico(@PathVariable String nombre) {
        return ResponseEntity.ok(service.informeCalorico(nombre));
    }

}
