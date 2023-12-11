package meli.demoW23Dto.controller;

import meli.demoW23Dto.dto.request.PersonaDto;
import meli.demoW23Dto.service.IPersonaService;
import meli.demoW23Dto.service.PersonaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonaController {

    @Autowired
    PersonaServiceImpl service;


    @GetMapping("/getCharacters/{variable}")
    public ResponseEntity<?> obtenerTodos(@PathVariable String variable) throws Exception {
        return new ResponseEntity<>(service.findCharacter(variable), HttpStatus.OK);
    }

}
