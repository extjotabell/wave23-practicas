package org.ejercicio.showroom.controller;

import org.ejercicio.showroom.model.dto.ClothesDto;
import org.ejercicio.showroom.model.dto.SaleDto;
import org.ejercicio.showroom.service.ISaleService;
import org.ejercicio.showroom.service.SaleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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

    @GetMapping("/{number:[0-9]+}")
    public ResponseEntity<?> getClothesCode(@PathVariable Integer number) {
        return new ResponseEntity<>(service.getSaleNumber(number), HttpStatus.OK);
    }

    @PutMapping("/{number:[0-9]+}")
    public ResponseEntity<?> getClothes(@RequestBody SaleDto saleDto,
                                        @PathVariable Integer number) {
        return new ResponseEntity<>(service.editSale(saleDto, number), HttpStatus.OK);
    }

    @DeleteMapping("/{number:[0-9]+}")
    public ResponseEntity<?> deleteClothes(@PathVariable Integer number) {
        service.deleteSale(number);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(params = "date")
    public ResponseEntity<?> getSalesDate(@RequestParam LocalDate date){
        return new ResponseEntity<>(service.getSalesDate(date), HttpStatus.OK);
    }
}
