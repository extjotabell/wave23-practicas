package org.ejercicio.starwars.controller;

import org.ejercicio.starwars.dto.CharacterDto;
import org.ejercicio.starwars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class CharacterController {

    @Autowired
    ICharacterService characterService;

    @GetMapping("/{name}")
    public ResponseEntity<?> sfindCharacterByName(@PathVariable String name) {
        try {
            List<CharacterDto> response = characterService.findCharactersByName(name);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
