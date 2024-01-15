package com.meli.showroom.controllers;

import com.meli.showroom.dtos.request.ClothesDTO;
import com.meli.showroom.services.ClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    public ClothesController(ClothesService clothesService) {
        this.clothesService = clothesService;
    }

    @PostMapping
    public ResponseEntity<ClothesDTO> createClothes(@RequestBody ClothesDTO clothesDTO) {
        return new ResponseEntity<>(clothesService.createClothes(clothesDTO), HttpStatus.CREATED);
    }
}