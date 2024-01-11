package com.example.compraclavecompuesta.controller;

import com.example.compraclavecompuesta.dto.CompraDTO;
import com.example.compraclavecompuesta.dto.CompraKeyDTO;
import com.example.compraclavecompuesta.service.CompraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraController {

  private final CompraService service;

  public CompraController(CompraService service) {
    this.service = service;
  }

  @PostMapping()
  public ResponseEntity<CompraKeyDTO> createCompra(@RequestBody CompraDTO compraDTO) {
    return ResponseEntity.ok(service.createCompra(compraDTO));
  }
}
