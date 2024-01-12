package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.SerieDto;

import java.util.List;

public interface SerieService {
    List<SerieDto> findBySeasonsCountGreaterThanEqual(Integer seasons);
}
