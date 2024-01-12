package com.meli.movies.services.impl;

import com.meli.movies.dtos.response.EpisodeDTO;
import com.meli.movies.mappers.EpisodeMapper;
import com.meli.movies.repositories.IEpisodeRepository;
import com.meli.movies.services.IEpisodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;

    public EpisodeService(IEpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDTO> getEpisodesByActor(String firstName, String lastName) {
        return episodeRepository.getEpisodesByActor(firstName, lastName).stream().map(EpisodeMapper::toDTO).toList();
    }
}
