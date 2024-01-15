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

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"paginas\": {\"gte\": \"?0\"}}}]}}")
    Iterable<Obra> findByPagesGreaterThan(String paginas);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"anioPublicacion\": {\"lte\": \"?0\"}}}]}}")
    Iterable<Obra> findByPublicacionBefore(String anio);

    @Query("{\"bool\": {\"filter\": [{\"range\": {\"anioPublicacion\": {\"gte\": \"?0\"}}}]}}")
    Iterable<Obra> findByPublicacionAfter(String anio);

    @Query("{\"match\": {\"editorial\":{\"query\": \"?0\"}}}")
    Iterable<Obra> findByEditorial(String editorial);
}
