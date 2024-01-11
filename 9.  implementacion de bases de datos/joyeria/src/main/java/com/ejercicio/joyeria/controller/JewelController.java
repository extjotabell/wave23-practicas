package com.ejercicio.joyeria.controller;

import com.ejercicio.joyeria.dto.request.JewelRequestDTO;
import com.ejercicio.joyeria.dto.response.JewelResponseDTO;
import com.ejercicio.joyeria.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class JewelController {
    @Autowired
    private IJewelService jewelService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJewel(@RequestBody JewelRequestDTO jewel) {
        JewelResponseDTO jewelResponse = jewelService.save(jewel);
        return new ResponseEntity<>("La joya fue agregada con exito, su nro de id es: " + jewelResponse.getNroIdentificatorio(), HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getJeweles() {
        return new ResponseEntity<>(jewelService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/jewerly/{id}")
    public ResponseEntity<?> getJewelById(@PathVariable Long id) {
        return new ResponseEntity<>(jewelService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJewelById(@PathVariable Long id) {
        jewelService.deleteById(id);
        return new ResponseEntity<>("La joya fue eliminada con exito", HttpStatus.OK);
    }

    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJewelById(@PathVariable Long id, @RequestBody JewelRequestDTO jewel) {
        jewelService.update(id, jewel);
        return new ResponseEntity<>("La joya fue actualizada con exito", HttpStatus.OK);
    }
}
