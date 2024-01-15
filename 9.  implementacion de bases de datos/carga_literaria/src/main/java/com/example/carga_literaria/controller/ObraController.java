package com.example.carga_literaria.controller;

import com.example.carga_literaria.model.Obra;
import com.example.carga_literaria.service.ObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ObraController {

    @Autowired
    ObraService service;

    @GetMapping("/list")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Obra obra){
        return ResponseEntity.ok(service.add(obra));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<?> findAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findAuthor(author));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> findTitle(@PathVariable String title){
        return ResponseEntity.ok(service.findTitle(title));
    }

    @GetMapping("/pages/{pages}")
    public ResponseEntity<?> findPages(@PathVariable Integer pages){
        return ResponseEntity.ok(service.findPages(pages));
    }

    @GetMapping("/greateryear/{year}")
    public ResponseEntity<?> findGreaterYear(@PathVariable Integer year){
        return ResponseEntity.ok(service.findGreaterYear(year));
    }

    @GetMapping("/loweryear/{year}")
    public ResponseEntity<?> findLowerYear(@PathVariable Integer year){
        return ResponseEntity.ok(service.findLowerYear(year));
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<?> findEditorial(@PathVariable String editorial){
        return ResponseEntity.ok(service.findEditorial(editorial));
    }
}
