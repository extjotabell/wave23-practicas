package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.MovieDto;
import com.meli.MoviesHQL.model.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDto> findByActorsRatingGreaterThan(Double rating);
    List<MovieDto> findByGenre(Long genreId);

}
