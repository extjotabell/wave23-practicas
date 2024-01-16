package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.service.IPrendaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final IPrendaService prendaService;
    public PrendaController(IPrendaService prendaService) {
        this.prendaService = prendaService;
    }

    @PostMapping("")
    public ResponseEntity<?> addPrenda(@RequestBody PrendaDTO prendaDTO) {
        return new ResponseEntity<>(prendaService.addPrenda(prendaDTO), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(prendaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("get/{code}")
    public ResponseEntity<?> getByCode(@PathVariable Integer code) {
        return new ResponseEntity<>(prendaService.getByCode(code), HttpStatus.OK);
    }

    @PutMapping("update/{code}")
    public ResponseEntity<?> updateByCode(@PathVariable Integer code, @RequestBody PrendaDTO prendaDTO) {
        return new ResponseEntity<>(prendaService.updateByCode(code, prendaDTO), HttpStatus.OK);
    }

    @DeleteMapping("delete/{code}")
    public ResponseEntity<?> deleteByCode(@PathVariable Integer code) {
        return new ResponseEntity<>(prendaService.deleteByCode(code), HttpStatus.OK);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<?> getBySize(@PathVariable Integer size) {
        return new ResponseEntity<>(prendaService.getBySize(size), HttpStatus.OK);
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<?> getByName(@RequestParam String name) {
        return new ResponseEntity<>(prendaService.getByName(name), HttpStatus.OK);
    }

}
