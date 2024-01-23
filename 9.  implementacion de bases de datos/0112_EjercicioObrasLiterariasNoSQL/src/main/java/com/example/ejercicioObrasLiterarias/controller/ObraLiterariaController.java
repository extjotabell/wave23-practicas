package com.example.ejercicioObrasLiterarias.controller;

import com.example.ejercicioObrasLiterarias.dto.ObraLiterariaDto;
import com.example.ejercicioObrasLiterarias.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obraLiteraria")
public class ObraLiterariaController {

    @Autowired
    private IObraLiterariaService obraLiterariaService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ObraLiterariaDto obraLiterariaDto){
        return ResponseEntity.ok(obraLiterariaService.save(obraLiterariaDto));
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(obraLiterariaService.findAll());
    }

}
