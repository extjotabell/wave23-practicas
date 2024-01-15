package com.meli.sqlshowroom.controller;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.service.ClothesServiceImpl;
import com.meli.sqlshowroom.service.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    IClothesService service;

    public ClothesController(ClothesServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClothesDTO clothes) {
        return new ResponseEntity<>(service.save(clothes), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> findByCode(@PathVariable Long code) {
        return new ResponseEntity<>(service.findByCode(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<?> update(@PathVariable Long code, @RequestBody ClothesDTO clothesDTO) {
        return new ResponseEntity<>(service.update(code, clothesDTO), HttpStatus.OK);
    }
}
