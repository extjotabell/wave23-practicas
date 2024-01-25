package com.melibootcamp.blog.services;

import com.melibootcamp.blog.dto.EntradaBlogDTO;
import com.melibootcamp.blog.dto.response.NuevaEntradaResponseDTO;
import com.melibootcamp.blog.dto.response.TodasLasEntradasResponseDTO;
import com.melibootcamp.blog.repository.EntradaBlogRepository;
import com.melibootcamp.blog.repository.IEntradaBlogRepository;

import java.util.List;

public interface IEntradaBlogService {

    public NuevaEntradaResponseDTO crearEntrada(EntradaBlogDTO entradaDTO);
    public EntradaBlogDTO buscarEntrada(String id);
    public TodasLasEntradasResponseDTO todasLasEntradas();
}
