package com.mercadolibre.jewerly.controller;

import com.mercadolibre.jewerly.model.Jewel;
import com.mercadolibre.jewerly.service.IJewelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class JewelController {

    @Autowired
    private IJewelService jewelService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> createJewel(@RequestBody Jewel jewel){
        jewelService.saveJewel(jewel);
        return new ResponseEntity<>("Joya creada correctamente", HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Jewel>> getJewels(){
        return new ResponseEntity<>(jewelService.getJewels(), HttpStatus.OK);
    }

    @PutMapping("/jewerly/delete/{id}")
    public ResponseEntity<String> deleteJewel(@PathVariable long id){
        jewelService.deleteJewel(id);
        return new ResponseEntity<>("Joya eliminada correctamente", HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<String> updateJewel(@PathVariable long id, @RequestBody Jewel updatedJewel) {
        jewelService.updateJewel(id, updatedJewel);
        String message = "Fue actualizada la joya";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
