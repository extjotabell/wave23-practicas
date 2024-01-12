package com.example.movieshql.service.movie;

import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.model.Movie;

import java.util.List;

public interface MovieService {
    List<MovieDto> findMoviesByActorsWithHigherRatingThan(Double rating);

    List<MovieDto> findMoviesByGenre(Long genreId);
}
