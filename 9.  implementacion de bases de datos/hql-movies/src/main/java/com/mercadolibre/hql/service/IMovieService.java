package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.MovieDTO;

import java.util.List;

public interface IMovieService {

    List<MovieDTO> findAllByActorsRatingGreaterThan(Double rating);
    List<MovieDTO> findAllByGenreName(String genre);
}
