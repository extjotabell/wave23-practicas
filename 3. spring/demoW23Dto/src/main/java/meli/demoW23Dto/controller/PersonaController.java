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


    @GetMapping("/getAll")
    public ResponseEntity<?> obtenerTodos(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> guardar(@RequestBody PersonaDto persona){
        return new ResponseEntity<>(service.savePeople(persona), HttpStatus.OK);
    }
}
