package com.example.movieshql.service.serie;

import com.example.movieshql.dto.SeriesDto;
import com.example.movieshql.model.Serie;

import java.util.List;

public interface SerieService {
    List<SeriesDto> findSeriesBySeasonAmountHigherThan(int amount);
}
