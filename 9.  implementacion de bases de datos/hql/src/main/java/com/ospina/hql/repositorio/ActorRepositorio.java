package com.ospina.hql.repositorio;

import com.ospina.hql.modelo.entidad.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ActorRepositorio extends CrudRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> encontrarActoresConPeliculaFavorita();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> encontrarActoresConRatingSuperiorA(@Param("rating") BigDecimal rating);

    @Query("SELECT a FROM Actor a JOIN a.peliculas p WHERE p.id = :idPelicula")
    List<Actor> encontrarActoresPorPelicula(@Param("idPelicula") Integer idPelicula);
}
