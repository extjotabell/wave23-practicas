package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.service.JoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyeriaController {
    @Autowired
    JoyeriaService service;

    //Crear una nueva joya y devolver el correspondiente status code con un mensaje informando su nro identificatorio.
    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.createJoya(joyaDTO), HttpStatus.CREATED);
    }

    //Devolver el listado de todas las joyas registradas.
    @GetMapping("/jewerly")
    public ResponseEntity<?> getJoyas(){
        return new ResponseEntity<>(service.getJoyas(),HttpStatus.OK);
    }

    //Eliminar una joya.
    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        service.deleteJoya(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Actualizar los datos de una joya.
    @PutMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(service.updateJoya(id, joyaDTO), HttpStatus.OK);
    }
}
