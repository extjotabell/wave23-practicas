package com.meli.calorias.controller;

import com.meli.calorias.dto.MensajeDto;
import com.meli.calorias.dto.PlatoDto;
import com.meli.calorias.service.CaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CaloriasController {

    @Autowired
    private CaloriasService caloriasService;

    @GetMapping("/calorias")
    public ResponseEntity<?> getCalorias(@RequestParam String nombre, @RequestParam double peso) {
        PlatoDto platoDto = caloriasService.getPlato(nombre, peso);
        MensajeDto notFoundMessage = new MensajeDto("El plato no existe");

        if (platoDto == null) return new ResponseEntity<>(notFoundMessage, HttpStatus.NOT_FOUND);
        else return new ResponseEntity<>(platoDto, HttpStatus.OK);
    }
}
