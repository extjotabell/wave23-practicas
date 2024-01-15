package com.example.miniserie.controller;

import com.example.miniserie.dto.MiniSerieDTO;
import com.example.miniserie.dto.MiniSeriesDTO;
import com.example.miniserie.dto.ResponseDTO;
import com.example.miniserie.model.MiniSerie;
import com.example.miniserie.service.MiniserieServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MiniserieController {
    private final MiniserieServiceImp service;

    public MiniserieController(MiniserieServiceImp service) {
        this.service = service;
    }

    @PostMapping ("/create")
    public ResponseEntity<ResponseDTO> saveMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO) {
        return ResponseEntity.ok(service.save(miniSerieDTO));
    }

    @GetMapping ("/getAll")
    public ResponseEntity<MiniSeriesDTO> getAllMiniseries() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping ("/edit/{id}")
    public ResponseEntity<ResponseDTO> editMiniserie(@RequestBody MiniSerieDTO miniSerieDTO) {
        return ResponseEntity.ok(service.save(miniSerieDTO));
    }

    @PostMapping ("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteMiniserie(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping ("findById/{id}")
    public ResponseEntity<MiniSerieDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
