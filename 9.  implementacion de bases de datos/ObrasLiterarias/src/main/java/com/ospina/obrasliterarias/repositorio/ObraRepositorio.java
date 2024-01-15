package com.ospina.obrasliterarias.repositorio;

import com.ospina.obrasliterarias.entidad.Obra;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraRepositorio extends ElasticsearchRepository<Obra, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"autor\": \"?0\"}}]}}")
    Iterable<Obra> findByAutor(String autor);

    @Query("{\"match\": {\"nombre\": \"?0\"}}")
    Iterable<Obra> findByTitulo(String titulo);

    @Query("{\"range\": {\"cantidadPaginas\": {\"gt\": \"?0\"}}}")
    Iterable<Obra> findByCantidadPaginasMayorA(int cantidadPaginas);

    @Query("{\"range\": {\"anioPublicacion\": {\"lt\": \"?0\"}}}")
    Iterable<Obra> findByAnioPublicacionAntesDe(int anioPublicacion);

    @Query("{\"range\": {\"anioPublicacion\": {\"gt\": \"?0\"}}}")
    Iterable<Obra> findByAnioPublicacionDespuesDe(int anioPublicacion);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"editorial\": \"?0\"}}]}}")
    Iterable<Obra> findByEditorial(String editorial);

}
