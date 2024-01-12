package com.example.clasenosql.repository;

import com.example.clasenosql.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    @Query("{\"match\": {\"autor\":{\"query\": \"?0\"}}}")
    List<Obra> findAllByAutor(String autor);
}
