package com.example.showroom.controller;

import com.example.showroom.dto.ClotheRequestDTO;
import com.example.showroom.service.ClotheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class ClotheController {

    private final ClotheService clotheService;

    public ClotheController(ClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClotheRequestDTO clotheRequestDTO) {
        clotheService.save(clotheRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) String containsInName) {
        return ResponseEntity.status(HttpStatus.OK).body(clotheService.findAll(containsInName));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clotheService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id, @RequestBody ClotheRequestDTO clotheRequestDTO) {
        clotheService.updateById(id, clotheRequestDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        clotheService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{size}")
    public ResponseEntity<?> findBySize(@PathVariable String size) {
        return ResponseEntity.status(HttpStatus.OK).body(clotheService.findBySize(size));
    }
}
