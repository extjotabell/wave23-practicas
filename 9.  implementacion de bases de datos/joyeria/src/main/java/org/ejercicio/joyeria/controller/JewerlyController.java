package org.ejercicio.joyeria.controller;

import org.ejercicio.joyeria.DTO.JewerlyDTO;
import org.ejercicio.joyeria.service.IJewerlyService;
import org.ejercicio.joyeria.service.JewerlyServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    private final IJewerlyService service;

    public JewerlyController(JewerlyServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveJewerly(@RequestBody JewerlyDTO jewerlyDTO) {
        return new ResponseEntity<>(service.saveJewerly(jewerlyDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getJewels() {
        return new ResponseEntity<>(service.getJewels(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewerly(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteJewerly(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable Long id,
                                           @RequestBody JewerlyDTO jewerlyDTO) {
        return new ResponseEntity<>(service.updateJewerly(id, jewerlyDTO), HttpStatus.OK);
    }
}
