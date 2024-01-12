package com.example.hql_vehiculos.controller;

import com.example.hql_vehiculos.service.TallerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TallerController {
    private final TallerService service;


    public TallerController(TallerService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAllVehicles(){
        return ResponseEntity.ok(service.getAllVehicles());
    }

    @GetMapping("/patenteMarca")
    public ResponseEntity<?> getPatenteMarca(){
        return ResponseEntity.ok(service.getPatenteMarca());
    }

    @GetMapping("/patenteMarcaModelo")
    public ResponseEntity<?> getPatenteMarcaModelo(){
        return ResponseEntity.ok(service.getPatenteMarcaModelo());
    }

    @GetMapping("/getFinal")
    public ResponseEntity<?> getFinal(){
        return ResponseEntity.ok(service.getFinal());
    }
}
