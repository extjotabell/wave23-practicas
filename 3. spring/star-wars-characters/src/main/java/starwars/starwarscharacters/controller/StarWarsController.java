package starwars.starwarscharacters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import starwars.starwarscharacters.service.CharacterService;

@RestController
public class StarWarsController {

    @Autowired
    CharacterService service;

    @GetMapping("/find/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name){
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }
}
