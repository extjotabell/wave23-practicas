package com.jpa.hql.service;

import com.jpa.hql.model.dto.MovieDTO;

import java.math.BigDecimal;
import java.util.Set;

public interface IMovieService {
    Set<MovieDTO> getAllMoviesWithActorsWithRatingGreaterThan(BigDecimal rating);
    Set<MovieDTO> getAllMoviesByGenre(String genreName);
}
