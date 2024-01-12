package com.spring.elasticsearch.repository;

import com.spring.elasticsearch.model.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findByNombreContaining(String nombreObra);

    List<ObraLiteraria> findByCantidadDePaginasGreaterThan(Integer pages);

    List<ObraLiteraria> findByAnioPublicacionGreaterThanEqual(Integer pages);

    List<ObraLiteraria> findByAnioPublicacionLessThan(Integer pages);

    List<ObraLiteraria> findByEditorial(String editorial);
}
