package com.meli.movies.services;

import com.meli.movies.dtos.response.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> getSeriesBySeasons(Integer seasons);
}
