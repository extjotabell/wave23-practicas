package com.example.SeguroAutos.controller;


import com.example.SeguroAutos.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeguroController {

    @Autowired
    SeguroService service;

    @GetMapping("/vehiculos")
    public ResponseEntity<?> getAllVehicles(){
        return ResponseEntity.ok(service.getAllVehicles());
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAllPatente(){
        return ResponseEntity.ok(service.getAllPatente());
    }

    @GetMapping("/patenteMarca")
    public ResponseEntity<?> getPatenteMarca(){
        return ResponseEntity.ok(service.getPatenteMarca());
    }

    @GetMapping("/getPatentePresentYear")
    public ResponseEntity<?> getPatentePresentYear(){
        return ResponseEntity.ok(service.getPatentePresentYear());
    }

    @GetMapping("/patenteMarcaModelo")
    public ResponseEntity<?> getPatenteMarcaModelo(){
        return ResponseEntity.ok(service.getPatenteMarcaModelo());
    }
}
