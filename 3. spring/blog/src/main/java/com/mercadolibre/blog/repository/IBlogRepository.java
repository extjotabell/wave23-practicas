package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    EntradaBlog crearEntrada(EntradaBlog entrada);

    EntradaBlog buscarId(Integer id);
    List<EntradaBlog> buscarTodas();
}
