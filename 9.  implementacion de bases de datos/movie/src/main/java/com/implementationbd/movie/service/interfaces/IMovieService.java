package com.implementationbd.movie.service.interfaces;

import com.implementationbd.movie.model.dto.MovieDto;

import java.util.List;

public interface IMovieService {
    List<MovieDto> getMoviesWithRatingActorGreaterThan(double rating);

    List<MovieDto> getMoviesByGenreId(Long genreId);
}
