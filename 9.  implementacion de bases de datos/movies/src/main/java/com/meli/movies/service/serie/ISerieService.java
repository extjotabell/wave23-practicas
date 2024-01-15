package com.meli.movies.service.serie;

import com.meli.movies.dto.EpisodesDTO;
import com.meli.movies.dto.SeriesDTO;

public interface ISerieService {
    SeriesDTO findBySeasonGreaterThan(Integer seasons);

    EpisodesDTO findEpisodesByActor(String actor);
}
