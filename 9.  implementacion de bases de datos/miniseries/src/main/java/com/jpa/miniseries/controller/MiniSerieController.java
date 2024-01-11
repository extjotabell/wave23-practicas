package com.jpa.miniseries.controller;

import com.jpa.miniseries.model.MiniSerie;
import com.jpa.miniseries.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MiniSerieController {

    @Autowired
    private IMiniSerieService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody MiniSerie miniSerie) {
        service.saveMiniSerie(miniSerie);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/mini-series")
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(service.getMiniSeries(), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> update(@RequestBody MiniSerie miniSerie) {
        service.saveMiniSerie(miniSerie);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        service.deleteMiniSerie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/mini-serie/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return new ResponseEntity<>(service.findMiniSerie(id), HttpStatus.OK);
    }

}
