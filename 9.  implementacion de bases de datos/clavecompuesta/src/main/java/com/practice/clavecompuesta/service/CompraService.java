package com.practice.clavecompuesta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.clavecompuesta.dto.CompraDTO;
import com.practice.clavecompuesta.dto.MessageDTO;
import com.practice.clavecompuesta.model.Compra;
import com.practice.clavecompuesta.repository.ICompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private ICompraRepository compraRepository;

    public CompraService(ICompraRepository compraRepository){
        this.compraRepository = compraRepository;
    }

    public MessageDTO createCompra(CompraDTO compraDTO) {
        Compra compra = new Compra(compraDTO.getClienteId(), compraDTO.getFecha(), compraDTO.getDescripcion());
        compraRepository.save(compra);
        return new MessageDTO("Compra creada exitosamente.");
    }
}
