package com.example.obrasLiterarias.repository;

import com.example.obrasLiterarias.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<ObraLiteraria,String > {

    //Retornar las obras de un autor dado por el usuario.
    @Query("{\"match\": {\"autor\":{\"query\": \"?0\"}}}")
    List<ObraLiteraria>findByAutor(String autor);

    //Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @Query("{\"match\": {\"nombre\":{\"query\": \"?0\"}}}")
    List<ObraLiteraria>findByTitle(String nombre);

    //Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @Query("{\"range\": {\"cantidadPaginas\": {\"gt\": ?0}}}")
    List<ObraLiteraria>findByQPages(Integer cantidadPaginas);

    //Retornar las obras que fueron publicadas antes y después de un año dado por el usuario
    // (crear 2 endpoints).
    @Query("{\"range\": {\"anioPublicacion\": {\"lt\": ?0}}}")
    List<ObraLiteraria>findByYearBefore(Integer anioPublicacion);

    @Query("{\"range\": {\"anioPublicacion\": {\"gt\": ?0}}}")
    List<ObraLiteraria>findByYearAfter(Integer anioPublicacion);

    //Retornar las obras de una misma editorial.
    @Query("{\"match\": {\"editorial\":{\"query\": \"?0\"}}}")
    List<ObraLiteraria>findByEditorial(String editorial);
}
