package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.model.Joya;
import com.bootcamp.joyeria.service.IJoyeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyeriaController {

    private final IJoyeriaService service;

    public JoyeriaController(IJoyeriaService service) {
        this.service = service;
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya){
        service.createJoya(joya);
        return new ResponseEntity<>("Joya " + joya.getNro_identificatorio() + " registrada.", HttpStatus.OK);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<?> getJoyas(){
        List<Joya> joyas = service.getJoyas();
        return new ResponseEntity<>(joyas, HttpStatus.OK);
    }

    @PostMapping("jewerly/delete/{id}")
    public ResponseEntity<?> deleteJoya(Long id){
        service.deleteJoya(id);
        return new ResponseEntity<>("La joya " + id + " fue eliminada.", HttpStatus.OK);
    }

    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id,
                                        @RequestParam(required = false) String nombre,
                                        @RequestParam(required = false) String material,
                                        @RequestParam(required = false) Double peso,
                                        @RequestParam(required = false) String particularidad,
                                        @RequestParam(required = false) Boolean posee_piedra){
        Joya joya = service.updateJoya(id, nombre, material, peso, particularidad, posee_piedra);
        return new ResponseEntity<>(joya, HttpStatus.OK);
    }

}
