package com.bootcamp.joyeriaLasPerlas.controller;


import com.bootcamp.joyeriaLasPerlas.dto.request.JewerlyDto;
import com.bootcamp.joyeriaLasPerlas.model.Jewerly;
import com.bootcamp.joyeriaLasPerlas.service.IJewerlyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JewerlyController {

    @Autowired
    private IJewerlyService jewerlyService;

    @PostMapping("/jewerly/new")
    public ResponseEntity<String> createjewerly(@RequestBody Jewerly jewerly) {
        jewerlyService.saveJewerly(jewerly);
        return new ResponseEntity<>("jewerly creada exitosamente. Nro Identificatorio:" + jewerly.getNro_identificatorio(), HttpStatus.CREATED);
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<Jewerly>> getjewerlys() {
        return new ResponseEntity<>(jewerlyService.getJewerlys(), HttpStatus.OK);
    }

    @PostMapping("/jewerly/delete/{id}")
    public String deletejewerly(@PathVariable long id) {
        jewerlyService.deleteJewerly(id);
        return "La jewerly fue borrada correctamente";
    }


    @PostMapping("/jewerly/update/{id_modificar}")
    public ResponseEntity<Jewerly> editJewerly(@PathVariable long id_modificar,
                                               @RequestBody JewerlyDto jewerlyDto) {

        Jewerly originalJewerly = jewerlyService.findJewerly(id_modificar);

        return new ResponseEntity<>(jewerlyService.updateJewerly(originalJewerly,jewerlyDto), HttpStatus.CREATED);

    }
}