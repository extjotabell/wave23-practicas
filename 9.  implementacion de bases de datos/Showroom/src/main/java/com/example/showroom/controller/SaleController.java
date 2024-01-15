package com.example.showroom.controller;

import com.example.showroom.dto.sale.SaleRequestDTO;
import com.example.showroom.service.sale.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody SaleRequestDTO saleRequestDTO) {
        saleService.save(saleRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(required = false) LocalDate date) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findAll(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id) {
        saleService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/clothes/{id}")
    public ResponseEntity<?> findClothesBySale(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(saleService.findClothesBySale(id));
    }
}
