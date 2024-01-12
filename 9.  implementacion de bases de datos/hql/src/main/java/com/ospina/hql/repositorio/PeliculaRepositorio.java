package com.ospina.hql.repositorio;

import com.ospina.hql.modelo.entidad.Pelicula;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PeliculaRepositorio extends CrudRepository<Pelicula, Long> {

    @Query("SELECT p FROM Pelicula p JOIN p.actores a WHERE a.rating > :rating")
    List<Pelicula> encontrarPeliculasPorRatingActores(@Param("rating") BigDecimal rating);

    @Query("SELECT p FROM Pelicula p WHERE p.genreId = :genreId")
    List<Pelicula> encontrarPeliculasPorGenero(@Param("genreId") Integer genreId);

}
