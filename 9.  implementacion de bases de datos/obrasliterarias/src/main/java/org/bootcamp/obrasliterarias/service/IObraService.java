package org.bootcamp.obrasliterarias.service;

import org.bootcamp.obrasliterarias.model.entity.Obra;

import java.util.List;

public interface IObraService {

    Obra save(Obra obra);

    List<Obra> getAll();

    List<Obra> findByAutor(String autor);

    List<Obra> findByTitle(String titulo);

    List<Obra> findByAmountOfPages(Integer paginas);

    List<Obra> findByYearBefore(Integer anio);

    List<Obra> findByYearAfter(Integer anio);

    List<Obra> findByEditorial(String editorial);

}
