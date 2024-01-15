package org.bootcamp.obrasliterarias.repository;

import org.bootcamp.obrasliterarias.model.entity.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, String> {

    //Retornar las obras de un autor dado por el usuario.
    @Query("{\"term\": {\"autor.keyword\":\"?0\"}}")
    List<Obra> findByAutor(String autor);

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @Query("{\"match\": {\"nombre\":{\"query\":\"?0\"}}}")
    List<Obra> findByTitle(String titulo);

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @Query("{\"bool\":{\"filter\":[{\"range\":{\"cantidadPaginas\":{\"gt\":?0}}}]}}")
    List<Obra> findByAmountOfPages(Integer paginas);

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    @Query("{\"bool\":{\"filter\":[{\"range\":{\"anioPublicacion\":{\"lt\":?0}}}]}}")
    List<Obra> findByYearBefore(Integer anio);

    @Query("{\"bool\":{\"filter\":[{\"range\":{\"anioPublicacion\":{\"gt\":?0}}}]}}")
    List<Obra> findByYearAfter(Integer anio);

    //Retornar las obras de una misma editorial.
    @Query("{\"term\":{\"editorial.keyword\":\"?0\"}}")
    List<Obra> findByEditorial(String editorial);

}
