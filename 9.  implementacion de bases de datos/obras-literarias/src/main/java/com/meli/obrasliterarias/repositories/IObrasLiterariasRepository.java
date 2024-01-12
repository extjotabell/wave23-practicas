package com.meli.obrasliterarias.repositories;

import com.meli.obrasliterarias.entities.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria,String> {

    @Query("{\"bool\": {\"filter\": {\"match\": {\"autor\": \"?0\"}}}}")
    List<ObraLiteraria> findByAutor(String autor);

    @Query("{\"bool\": {\"filter\": {\"range\": {\"cantidad_de_paginas\": {\"gt\": \"?0\"}}}}}")
    List<ObraLiteraria> findByCantidadDePaginasGreaterThan(Integer paginas);
}
