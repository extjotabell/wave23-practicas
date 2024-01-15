package com.mercadolibre.obras_literarias.repository;

import com.mercadolibre.obras_literarias.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    @Query("{\"match\": {\"autor\":{\"query\": \"?0\"}}}")
    List<Obra> findByAutor(String autor);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Obra> findByTitleContainsWord(String nombre);

    @Query("{\"match\": {\"cant_paginas\":{\"query\": \"?0\"}}}")
    List<Obra> findByPagesCount(Integer cant_paginas);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"anio_publicacion\": {\"lte\": \"?0\"}}}]}}")
    List<Obra> findByYearBefore(Integer anio_publicacion);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"anio_publicacion\": {\"gte\": \"?0\"}}}]}}")
    List<Obra> findByYearAfter(Integer anio_publicacion);

    @Query("{\"match\": {\"editorial\":{\"query\": \"?0\"}}}")
    List<Obra> findByEditorial(String editorial);
}
