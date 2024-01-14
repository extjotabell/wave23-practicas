package com.meli.movies.service;

import com.meli.movies.dto.SeriesDTO;

public interface ISerieService {
    SeriesDTO findBySeasonGreaterThan(Integer seasons);
}
