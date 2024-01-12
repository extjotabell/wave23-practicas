package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movies, Integer> {

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("FROM Movies m INNER JOIN ActorMovie am ON m.id = am.moviesByMovieId.id INNER JOIN Actors a ON am.actorsByActorId.id = a.id WHERE a.rating > :rating")
    List<Movies> findAllByActorsRatingGreaterThan(@Param("rating") Double rating);
    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("FROM Movies m JOIN Genres g ON m.genresByGenreId.id = g.id WHERE g.name = :genre")
    List<Movies> findAllByGenreName(@Param("genre") String genre);
}
