package com.melibootcamp.blog.repository;

import com.melibootcamp.blog.entity.EntradaBlog;

import java.util.List;


public interface IEntradaBlogRepository {
    void agregarNuevaEntrada(EntradaBlog entradaNueva);
    EntradaBlog buscarPorId(String id);
    List<EntradaBlog> todasLasEntradas();
}
