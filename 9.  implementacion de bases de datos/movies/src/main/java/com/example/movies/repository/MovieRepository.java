package com.example.movies.repository;

import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Query("select m from Movie m inner join m.genre as g where g.name =:name ")
    List<Movie> fidMoviesWithGenre(@Param("name") String genre);
}
