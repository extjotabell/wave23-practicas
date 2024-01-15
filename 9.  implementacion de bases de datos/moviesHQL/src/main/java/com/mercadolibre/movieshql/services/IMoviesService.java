package com.mercadolibre.movieshql.services;

import com.mercadolibre.movieshql.model.dtos.MoviesDTO;

import java.util.List;

public interface IMoviesService {

    List<MoviesDTO> findMoviesByGenre(String genres);
    List<MoviesDTO> findActorsWithRatingHigherThanRatingValue(Double rating);
}
