package com.meli.showroom.controllers;

import com.meli.showroom.dtos.request.ClothesDTO;
import com.meli.showroom.services.ClothesService;
import lombok.Getter;
import lombok.Value;
import org.hibernate.annotations.AnyDiscriminatorValues;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @GetMapping
    public ResponseEntity<List<ClothesDTO>> getAllClothes() {
        return new ResponseEntity<>(clothesService.getAllClothes(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothesDTO> getClothesByCode(@PathVariable String code) {
        return new ResponseEntity<>(clothesService.getClothesByCode(code), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClothesDTO> createClothes(@RequestBody ClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.createClothes(clothesDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{code}")
    public ResponseEntity<ClothesDTO> updateClothes(@PathVariable String code, @RequestBody ClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.updateClothes(code, clothesDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
public ResponseEntity<Boolean> deleteClothes(@PathVariable String code) {
        return new ResponseEntity<>(clothesService.deleteClothes(code),HttpStatus.OK);
    }
}