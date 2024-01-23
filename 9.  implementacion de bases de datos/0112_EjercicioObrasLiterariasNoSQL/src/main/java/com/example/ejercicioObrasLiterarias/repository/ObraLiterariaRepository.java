package com.example.ejercicioObrasLiterarias.repository;

import com.example.ejercicioObrasLiterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, Integer> {
}
