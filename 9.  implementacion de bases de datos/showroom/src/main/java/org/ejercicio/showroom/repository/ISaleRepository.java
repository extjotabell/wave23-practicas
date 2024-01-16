package org.ejercicio.showroom.repository;

import org.ejercicio.showroom.model.entty.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
}
