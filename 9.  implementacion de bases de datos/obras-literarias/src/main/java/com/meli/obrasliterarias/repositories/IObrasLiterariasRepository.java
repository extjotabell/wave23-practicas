package com.meli.obrasliterarias.repositories;

import com.meli.obrasliterarias.entities.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObrasLiterariasRepository extends ElasticsearchRepository<ObraLiteraria,String> {

}
