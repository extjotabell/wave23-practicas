package com.example.jewelryStore.controller;

import com.example.jewelryStore.dto.JewelDTO;
import com.example.jewelryStore.service.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewelry")
public class JewelController {

    @Autowired
    JewelService service;

    @PostMapping("/new")
    public ResponseEntity<?> addJewel(@RequestBody JewelDTO jewel){
        return new ResponseEntity<>(service.addJewel(jewel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllJewelry(){
        return new ResponseEntity<>(service.getJewels(), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(service.deleteJewel(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJewel(@PathVariable Long id_modificar, @RequestBody JewelDTO jewel){
        return new ResponseEntity<>(service.updateJewel(id_modificar, jewel), HttpStatus.OK);
    }
}
