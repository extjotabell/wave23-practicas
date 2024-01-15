package com.example.obraliteraria.repository;

import com.example.obraliteraria.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    @Query("{\"match\": {\"autor.nombre\":{\"query\": \"?0\"}}}")
    List<ObraLiteraria> findByAutorNombre(String autorNombre);

    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<ObraLiteraria> findByNombre(String nombre);

    public List<ObraLiteraria> findByPaginasGreaterThan(int paginas);

    List<ObraLiteraria> findByAñoPublicacionLessThanEqual(int fromYear);

    List<ObraLiteraria> findByAñoPublicacionGreaterThanEqual(int fromYear);

    List<ObraLiteraria> findByEditorial(String editorial);
}
