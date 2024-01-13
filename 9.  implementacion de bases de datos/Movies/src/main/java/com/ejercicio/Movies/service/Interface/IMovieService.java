package com.ejercicio.Movies.service.Interface;

import com.ejercicio.Movies.dto.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieDTO> findMoviesWithActorsWithRatingGreaterThan(double rating);
    List<MovieDTO> findMoviesByGenre(String genre);
}