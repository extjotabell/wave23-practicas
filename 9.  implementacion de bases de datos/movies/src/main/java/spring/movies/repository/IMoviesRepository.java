package spring.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.movies.dto.MovieDto;
import spring.movies.model.Movie;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie,Long> {

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN m.actorMovies am " +
            "JOIN am.actor a " +
            "WHERE a.rating > :parametroRating")
    List<MovieDto> findMoviesByActorsRatingGreaterThan(@Param("parametroRating") Double parametroRating);

    List<MovieDto> findByGenreIdEquals(Long parametroGenre);
}
