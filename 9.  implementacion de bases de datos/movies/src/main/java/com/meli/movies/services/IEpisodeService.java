package com.meli.movies.services;

import com.meli.movies.dtos.response.EpisodeDTO;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDTO> getEpisodesByActor(String firstName, String lastName);
}
