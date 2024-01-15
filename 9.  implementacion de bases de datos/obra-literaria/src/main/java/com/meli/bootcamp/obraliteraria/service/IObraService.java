package com.meli.bootcamp.obraliteraria.service;

import com.meli.bootcamp.obraliteraria.dto.ObraDto;
import com.meli.bootcamp.obraliteraria.entity.Obra;

import java.util.List;

public interface IObraService {
    ObraDto save(ObraDto obraDto);
    List<ObraDto> findAll();
    List<ObraDto> findByAutor(String nombreAutor);

    List<ObraDto> findByTitle(String palabras);

    List<ObraDto> findByCantidadPaginasGreaterThan(int year);


    List<ObraDto> findByFechaPublicacionLessThan(int year);

    List<ObraDto> findByFechaPublicacionGreaterThan(int year);


    List<ObraDto> findByEditorial(String editorial);
}
