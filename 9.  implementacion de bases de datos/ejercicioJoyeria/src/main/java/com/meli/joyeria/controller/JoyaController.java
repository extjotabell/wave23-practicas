package com.meli.joyeria.controller;

import com.meli.joyeria.dto.request.JoyaCreationDTO;
import com.meli.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final JoyaService service;

    public JoyaController(JoyaService service){
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<?> addJewelry(@RequestBody JoyaCreationDTO joyaDto){
        return new ResponseEntity<>(service.addJewelry(joyaDto), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllJewelry(){
        return new ResponseEntity<>(service.getAllJewelry(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewelry(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteJewelry(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> uodateJewelry(@PathVariable Long id){
        return new ResponseEntity<>(service.updateJewelry(id), HttpStatus.OK);
    }
}
