package com.practice.clavecompuesta.service;

import com.practice.clavecompuesta.dto.CompraDTO;
import com.practice.clavecompuesta.dto.MessageDTO;

public interface ICompraService {
    MessageDTO createCompra(CompraDTO compraDTO);
}
