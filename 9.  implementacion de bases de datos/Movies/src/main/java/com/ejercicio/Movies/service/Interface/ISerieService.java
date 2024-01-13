package com.ejercicio.Movies.service.Interface;

import com.ejercicio.Movies.dto.SerieDTO;

import java.util.List;

public interface ISerieService {
    List<SerieDTO> findSeriesWithMoreThanNumberOfSeasons(int numberOfSeasons);
}
