package com.meli.bootcamp.obraliteraria.repository;

import com.meli.bootcamp.obraliteraria.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra,String> {
    List<Obra> findByAutor(String nombreAutor);
    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<Obra> findByTitle(String palabras);

    List<Obra> findByCantidadPaginasGreaterThan(int pages);

    List<Obra> findByFechaPublicacionLessThan(int year);

    List<Obra> findByFechaPublicacionGreaterThan(int year);

    List<Obra> findByEditorial(String editorial);
}
