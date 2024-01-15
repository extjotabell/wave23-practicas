package com.meli.ObrasLiterarias.repository;

import com.meli.ObrasLiterarias.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"autor\": \"?0\"}}]}}")
    Iterable<Obra> findByAutor(String autor);

    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    Iterable<Obra> findByTituloContains(String titulo);

    @Query("{\"range\": {\"cantidadPaginas\": {\"gt\": \"?0\"}}}")
    Iterable<Obra> findByCantidadPaginasGreaterThan(Integer cantidadPaginas);

    @Query("{\"range\": {\"yearPublicacion\": {\"lt\": \"?0\"}}}")
    Iterable<Obra> findByYearPublicacionBefore(Integer yearPublicacion);

    @Query("{\"range\": {\"yearPublicacion\": {\"gt\": \"?0\"}}}")
    Iterable<Obra> findByYearPublicacionAfter(Integer yearPublicacion);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"editorial\": \"?0\"}}]}}")
    Iterable<Obra> findByEditorial(String editorial);

}