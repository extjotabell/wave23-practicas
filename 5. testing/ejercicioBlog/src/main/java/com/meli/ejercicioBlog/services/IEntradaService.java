package com.meli.ejercicioBlog.services;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogListaResponseDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogResponseDTO;
import com.meli.ejercicioBlog.dtos.response.MessageResponseDTO;

public interface IEntradaService {
    MessageResponseDTO crear(EntradaBlogCreacionRequestDTO entrada);
    EntradaBlogResponseDTO find(String id);
    EntradaBlogListaResponseDTO getAll();
}
