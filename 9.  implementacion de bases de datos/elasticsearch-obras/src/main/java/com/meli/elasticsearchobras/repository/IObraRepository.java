package com.meli.elasticsearchobras.repository;

import com.meli.elasticsearchobras.domain.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    @Query("{\"match\": {\"autor\":{\"query\": \"?0\"}}}")
    Iterable<Obra> findByAuthor(String autor);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    Iterable<Obra> findByNombre(String nombre);
}
