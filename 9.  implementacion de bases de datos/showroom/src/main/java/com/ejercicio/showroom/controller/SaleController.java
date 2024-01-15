package com.ejercicio.showroom.controller;

import com.ejercicio.showroom.dto.SaleDTO;
import com.ejercicio.showroom.service.Interface.SaleServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/sale")
public class SaleController {
    @Autowired
    private SaleServiceImpl saleService;

    @PostMapping("")
    public ResponseEntity<?> createSale(@RequestBody SaleDTO saleDTO) {
        return new ResponseEntity<>(saleService.createSale(saleDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllSales(@PathVariable(required = false) String date) {
        if (date != null) {
            return new ResponseEntity<>(saleService.getAllSalesByDate(date), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(saleService.getAllSales(), HttpStatus.OK);
        }
    }

    @GetMapping("/{number}")
    public ResponseEntity<?> getSaleById(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getSaleById(number), HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<?> updateSale(@RequestBody SaleDTO saleDTO, @PathVariable Long number) {
        return new ResponseEntity<>(saleService.updateSale(saleDTO, number), HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<?> deleteSale(@PathVariable Long number) {
        saleService.deleteSale(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<?> getAllSalesByClothe(@PathVariable Long number) {
        return new ResponseEntity<>(saleService.getAllSalesByClothe(number), HttpStatus.OK);
    }
}
