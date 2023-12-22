package com.example.star_wars.controller;

import com.example.star_wars.dto.CharacterDTO;
import com.example.star_wars.service.StarWarsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @GetMapping("/{filterParam}")
    public ResponseEntity<List<CharacterDTO>> filterByName(@PathVariable String filterParam) {
        return ResponseEntity.ok(starWarsService.filterByName(filterParam));
    }
}
