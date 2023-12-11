package com.mercadolibre.starWars.controller;

import com.mercadolibre.starWars.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to handle requests related to Star Wars characters.
 */
@RestController
@RequestMapping("/api/star-wars")
public class CharacterController {

    @Autowired
    private ICharacterService service;

    /**
     * Handles GET requests to retrieve information about a Star Wars character by name.
     *
     * @param name The name of the character to search for.
     * @return ResponseEntity with the body containing character information or an error message in case of failure.
     */
    @GetMapping("/getCharacter/{name}")
    public ResponseEntity<?> getCharacter(@PathVariable String name){
        try {
            return new ResponseEntity<>(service.getCharacterByName(name), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al buscar un personaje de Star Wars por nombre");
        }
    }

    /**
     * Retrieves all characters from the Star Wars universe.
     *
     * @return ResponseEntity containing a list of characters on success (HTTP 200 OK),
     * or an error message with HTTP 500 Internal Server Error on failure.
     */
    @GetMapping("/getAllCharacter")
    public ResponseEntity<?> getCharacter(){
        try {
            return new ResponseEntity<>(service.getAllCharacters(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al intentar listar a los personajes de Star Wars");
        }
    }

}
