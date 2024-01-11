package com.meli.movies.repositories;

import com.meli.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMovieRepository extends JpaRepository<Movie, Long> {
}
