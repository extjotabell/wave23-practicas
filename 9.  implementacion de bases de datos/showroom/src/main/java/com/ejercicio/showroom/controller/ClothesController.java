package com.ejercicio.showroom.controller;

import com.ejercicio.showroom.dto.ClothesDTO;
import com.ejercicio.showroom.service.ClothesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/clothes")
public class ClothesController {
    @Autowired
    private ClothesServiceImpl clothesService;

    @PostMapping("")
    public ResponseEntity<?> createClothes(@RequestBody ClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.createClothes(clothesDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClothesById(@PathVariable Long id) {
        return new ResponseEntity<>(clothesService.getClothesById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClothes(@RequestBody ClothesDTO clothesDTO, @PathVariable Long id) {
        return new ResponseEntity<>(clothesService.updateClothes(clothesDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClothes(@PathVariable Long id) {
        clothesService.deleteClothes(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getAllClothesByName(@PathVariable String name) {
        return new ResponseEntity<>(clothesService.getAllClothesByName(name), HttpStatus.OK);
    }

    @GetMapping("/size/{size}")
    public ResponseEntity<?> getALlClothesBySize(@PathVariable String size) {
        return new ResponseEntity<>(clothesService.getAllClothesBySize(size), HttpStatus.OK);
    }
}
