package com.meli.movies.service.movie;

import com.meli.movies.dto.MoviesDTO;

import java.math.BigDecimal;

public interface IMovieService {
    MoviesDTO findByActorRatingGreaterThan(BigDecimal rating);
}
