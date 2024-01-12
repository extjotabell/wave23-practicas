package com.example.movies.repository;

import com.example.movies.dto.MovieSimpleDTO;
import com.example.movies.models.Actor;
import com.example.movies.models.Movie;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

  @Query("select movie from Movie movie inner join movie.actors actors where actors.rating > :rating")
  List<Movie> findAllWithRatingHigher(@Param("rating") BigDecimal rating);

  @Query("select movie from Movie movie inner join movie.genre genre where genre.name=:genre")
  List<Movie> getMoviesOfGenre(@Param("genre") String genre);
}
