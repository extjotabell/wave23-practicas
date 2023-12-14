package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntradaRequestDto;
import com.mercadolibre.blog.dto.response.EntradaDto;
import com.mercadolibre.blog.dto.response.EntradaIdDto;
import com.mercadolibre.blog.dto.response.EntradasDto;

public interface IBlogService {
    EntradaIdDto crearEntrada(EntradaRequestDto request);
    EntradaDto buscarPorId(Integer id);
    EntradasDto buscarTodas();
}
