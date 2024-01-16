package org.ejercicio.showroom.controller;

import org.ejercicio.showroom.model.dto.SaleDto;
import org.ejercicio.showroom.service.ISaleService;
import org.ejercicio.showroom.service.SaleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService service;

    public SaleController(SaleServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> saveSale(@RequestBody SaleDto saleDto) {
        return new ResponseEntity<>(service.saveSale(saleDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getSales() {
        return new ResponseEntity<>(service.getSales(), HttpStatus.OK);

    }
}
