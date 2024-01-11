package com.example.ejercicioClaveCompuesta.controller;

import com.example.ejercicioClaveCompuesta.dto.NewCompraRequestDto;
import com.example.ejercicioClaveCompuesta.service.ICompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private ICompraService compraService;

    public CompraController(ICompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody NewCompraRequestDto newCompraRequestDto){
        compraService.save(newCompraRequestDto);
        return ResponseEntity.ok("{'message' : 'Ok'}");
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(compraService.findAll());
    }
}
