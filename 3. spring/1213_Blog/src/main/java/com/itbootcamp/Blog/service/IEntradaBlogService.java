package com.itbootcamp.Blog.service;

import com.itbootcamp.Blog.dto.EntradaBlogDto;

import java.util.HashMap;

public interface IEntradaBlogService {
    public EntradaBlogDto agregarEntradaBlog(EntradaBlogDto nuevaEntradaDto);
    public HashMap<Integer, EntradaBlogDto> mostrarTodas();
    public EntradaBlogDto buscarPorId(int id);
}
