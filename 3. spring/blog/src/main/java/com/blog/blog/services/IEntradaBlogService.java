package com.blog.blog.services;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.dto.response.NuevaEntradaResponseDTO;
import com.blog.blog.dto.response.TodasLasEntradasDTO;

public interface IEntradaBlogService {

    public NuevaEntradaResponseDTO crearEntrada(EntradaBlogDTO entradaBlogDTO);

    public EntradaBlogDTO buscarEntrada(Integer id);

    public TodasLasEntradasDTO todasLasEntradas();
}
