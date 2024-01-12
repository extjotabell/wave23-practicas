package com.example.obrasliterariaselastic.repository;

import com.example.obrasliterariaselastic.entity.Autor;
import com.example.obrasliterariaselastic.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ObraRepository extends ElasticsearchRepository<Obra, String> {

    @Query("""
            {"bool": {"filter": [{"match": {"autor.nombre": "?0"}}]}}
           """)
    List<Obra> findByAutor(String nombre);

    List<Obra> findByTituloContaining(String titulo);

    List<Obra> findByPaginasGreaterThan(Integer paginas);

    List<Obra> findByFechaGreaterThan(Integer fecha);

    List<Obra> findByFechaIsLessThan(Integer fecha);
}
