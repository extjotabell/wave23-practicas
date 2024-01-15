package com.mercadolibre.movieshql.services;

import com.mercadolibre.movieshql.model.dtos.EpisodesDTO;

import java.util.List;

public interface IEpisodesService {

    List<EpisodesDTO> findEpisodesOfAnySeriesByActor(String actorName, String actorLastName);
}
