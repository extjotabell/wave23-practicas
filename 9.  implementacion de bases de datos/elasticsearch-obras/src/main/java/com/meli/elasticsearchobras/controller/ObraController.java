package com.meli.elasticsearchobras.controller;

import com.meli.elasticsearchobras.domain.DTO.ObraDTO;
import com.meli.elasticsearchobras.service.IObraService;
import com.meli.elasticsearchobras.service.ObraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObraController {

    private final IObraService service;

    public ObraController(ObraServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ObraDTO obra) {
        return new ResponseEntity<>(service.save(obra), HttpStatus.CREATED);
    }

    @GetMapping("/find-by-autor/{autor}")
    public ResponseEntity<?> findByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.findByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/find-by-nombre/{nombre}")
    public ResponseEntity<?> findByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(service.findByNombre(nombre), HttpStatus.OK);
    }
}
