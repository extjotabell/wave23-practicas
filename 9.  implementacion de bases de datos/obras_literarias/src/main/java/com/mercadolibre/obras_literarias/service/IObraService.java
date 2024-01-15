package com.mercadolibre.obras_literarias.service;

import com.mercadolibre.obras_literarias.entity.Obra;

import java.util.List;

public interface IObraService {
    Obra save(Obra obra);

    List<Obra> findAll();

    List<Obra> findByAutor(String name);

    List<Obra> findByTitleContainsWord(String palabra);

    List<Obra> findByPagesCount(Integer cantidad);

    List<Obra> findByYearBefore(Integer anio);

    List<Obra> findByYearAfter(Integer anio);

    List<Obra> findByEditorial(String editorial);
}
