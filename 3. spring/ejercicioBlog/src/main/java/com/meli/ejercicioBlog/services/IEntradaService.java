package com.meli.ejercicioBlog.services;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogListaResponseDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogResponseDTO;

public interface IEntradaService {
    String crear(EntradaBlogCreacionRequestDTO entrada);
    EntradaBlogResponseDTO find(String id);
    EntradaBlogListaResponseDTO getAll();
}
