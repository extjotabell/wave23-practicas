package com.practice.joyeria.controllers;

import com.practice.joyeria.dtos.JoyaDTO;
import com.practice.joyeria.repositories.JoyaRepository;
import com.practice.joyeria.services.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    @Autowired
    private JoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<?> saveJewerly(@RequestBody JoyaDTO joyaDTO) {
        return new ResponseEntity<>(joyaService.saveJewerly(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewerly() {
        return new ResponseEntity<>(joyaService.getAllJewerly(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> logicDeleteJewerly(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.logicDeleteJewerly(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJewerly(@PathVariable Long id) {
        return new ResponseEntity<>(joyaService.getJewerly(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateJewerly(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.updateJewerly(id, joyaDTO), HttpStatus.OK);
    }


}
