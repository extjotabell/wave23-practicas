package com.mercadolibre.movieshql.services;

import com.mercadolibre.movieshql.model.dtos.SeriesDTO;

import java.util.List;

public interface ISeriesService {

    public List<SeriesDTO> findSeriesHigherThanSeasonsValue(Integer seasons);
}
