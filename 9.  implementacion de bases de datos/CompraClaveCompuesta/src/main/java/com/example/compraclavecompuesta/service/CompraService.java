package com.example.compraclavecompuesta.service;

import com.example.compraclavecompuesta.dto.CompraDTO;
import com.example.compraclavecompuesta.dto.CompraKeyDTO;
import com.example.compraclavecompuesta.model.Compra;
import com.example.compraclavecompuesta.repository.CompraRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

  private final CompraRepository repository;

  public CompraService(CompraRepository repository) {
    this.repository = repository;
  }

  public CompraKeyDTO createCompra(CompraDTO compraDTO) {
    ObjectMapper mapper = new ObjectMapper();
    Compra compra = mapper.convertValue(compraDTO, Compra.class);
    repository.save(compra);
    return new CompraKeyDTO(compra.getClientId(), compra.getDate());
  }
}
