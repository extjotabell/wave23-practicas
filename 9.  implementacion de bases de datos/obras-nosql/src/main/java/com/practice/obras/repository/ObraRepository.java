package com.practice.obras.repository;

import com.practice.obras.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {
    @Query("{\"match\": {\"autor\":{\"query\": \"?0\"}}}")
    List<Obra> findAllByAutor(String autor);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Obra> findAllByNombreKeywords(String keywords);

    List<Obra> findByCantidadPaginasGreaterThan(String number);

    List<Obra> findByAnioPublicacionLessThan(String year);

    List<Obra> findByAnioPublicacionGreaterThan(String year);

    @Query("{\"match\": {\"editorial\":{\"query\": \"?0\"}}}")
    List<Obra> findAllByEditorial(String editorial);
}
