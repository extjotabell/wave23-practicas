package com.example.Hql.repository;

import com.example.Hql.model.dto.MovieDto;
import com.example.Hql.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.actorMovies am JOIN am.actor a WHERE a.rating > :parametroRating")
    List<MovieDto> findMoviesByActorsRatingGreaterThan(@Param("parametroRating") Double parametroRating);

    List<MovieDto> findByGenreIdEquals(Long parametroGenre);
}
