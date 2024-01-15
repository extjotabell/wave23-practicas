package com.meli.ObrasLiterarias.service;

import com.meli.ObrasLiterarias.dto.ObraDto;

import java.util.List;

public interface ObraService {

    List<ObraDto> findAll();
    ObraDto findById(String id);
    ObraDto save(ObraDto empleado);
    void deleteById(String id);

    List<ObraDto> findByAuthor(String author);
    List<ObraDto> findByTituloContains(String titulo);
    List<ObraDto> findByCantidadPaginasGreaterThan(Integer cantidadPaginas);
    List<ObraDto> findByYearPublicacionBefore(Integer yearPublicacion);
    List<ObraDto> findByYearPublicacionAfter(Integer yearPublicacion);
    List<ObraDto> findByEditorial(String editorial);

}
