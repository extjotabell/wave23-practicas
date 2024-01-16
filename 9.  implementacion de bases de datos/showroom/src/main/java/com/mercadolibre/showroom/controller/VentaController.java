package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.VentaDTO;
import com.mercadolibre.showroom.service.IVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private final IVentaService ventaService;
    public VentaController(IVentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("")
    public ResponseEntity<?> addSale(@RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.addSale(ventaDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getSales() {
        return new ResponseEntity<>(ventaService.getSales(), HttpStatus.OK);
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getSaleByNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(ventaService.getSaleByNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSaleByNumber(@PathVariable Integer number, @RequestBody VentaDTO ventaDTO) {
        return new ResponseEntity<>(ventaService.updateSaleByNumber(number, ventaDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSaleByNumber(@PathVariable Integer number) {
        return new ResponseEntity<>(ventaService.deleteSaleByNumber(number), HttpStatus.OK);
    }

    @GetMapping("get-by-date")
    public ResponseEntity<?> getSalesByDate(@RequestParam("date") LocalDate date) {
        return new ResponseEntity<>(ventaService.getSalesByDate(date), HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getClothesOfSale(@PathVariable Integer number) {
        return new ResponseEntity<>(ventaService.getClothesOfSale(number), HttpStatus.OK);
    }

}
