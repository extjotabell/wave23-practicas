package com.implementationbd.movie.repository;

import com.implementationbd.movie.model.entity.Actor;
import com.implementationbd.movie.model.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IMovieRepository extends CrudRepository<Actor, Long> {

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> getMoviesWithRatingActorGreaterThan(double rating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("SELECT m FROM Movie m WHERE m.genre.id = :genreId")
    List<Movie> getMoviesByGenreId(Long genreId);
}
