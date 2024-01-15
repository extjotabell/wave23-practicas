package com.meli.sqlshowroom.controller;

import com.meli.sqlshowroom.dto.ClothesDTO;
import com.meli.sqlshowroom.service.ClothesServiceImpl;
import com.meli.sqlshowroom.service.IClothesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {
    IClothesService service;

    public ClothesController(ClothesServiceImpl service) { this.service = service; }
}
