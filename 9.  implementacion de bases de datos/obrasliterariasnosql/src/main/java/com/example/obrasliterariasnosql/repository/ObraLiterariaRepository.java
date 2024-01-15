package com.example.obrasliterariasnosql.repository;

import com.example.obrasliterariasnosql.entity.ObraLiteraria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findByAutor(String autor);
    List<ObraLiteraria> findByCantidadPaginasGreaterThanEqual(Integer cantidadPaginas);
    List<ObraLiteraria> findByAnioPrimeraPublicacionGreaterThanEqual(Integer anioPrimeraPublicacion);
    List<ObraLiteraria> findByAnioPrimeraPublicacionLessThanEqual(Integer anioPrimeraPublicacion);
    List<ObraLiteraria> findByEditorial(String editorial);
}
