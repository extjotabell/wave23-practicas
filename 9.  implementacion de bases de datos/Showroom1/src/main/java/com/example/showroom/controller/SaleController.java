package com.example.showroom.controller;

import com.example.showroom.model.Sale;
import com.example.showroom.service.SaleService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

  private final SaleService saleService;

  public SaleController(SaleService saleService) {
    this.saleService = saleService;
  }

  @PostMapping()
  public ResponseEntity<?> createSale(@RequestBody Sale sale) {
    return ResponseEntity.ok(saleService.createSale(sale));
  }

  @GetMapping
  public ResponseEntity<?> getSales(@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
    if(date==null){
      return ResponseEntity.ok(saleService.getSales());
    }
    return ResponseEntity.ok(saleService.findAllByDate(date));
  }

  @GetMapping("/{number}")
  public ResponseEntity<?> getSaleById(@PathVariable int number){
    return ResponseEntity.ok(saleService.getSaleById(number));
  }

  @PutMapping("/{number}")
  public ResponseEntity<?> updateSale(@PathVariable int number, @RequestBody Sale sale){
    return ResponseEntity.ok(saleService.updateSale(number,sale));
  }

  @DeleteMapping("/{number}")
  public ResponseEntity<?> deleteSale(@PathVariable int number){
    return ResponseEntity.ok(saleService.deleteSale(number));
  }

  @GetMapping("/clothes/{number}")
  public ResponseEntity<?> getClothesFromSale(@PathVariable int number){
    return ResponseEntity.ok(saleService.findClothesFromSale(number));
  }

}
