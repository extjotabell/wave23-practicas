package com.itbootcamp.EjercicioStarWars.controller;

import com.itbootcamp.EjercicioStarWars.service.CharacterServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    @Autowired
    CharacterServiceImpl characterService;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(characterService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return ResponseEntity.ok(characterService.findByName(name));
    }

}
