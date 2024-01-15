package com.mercadolibre.movieshql.services.impl;

import com.mercadolibre.movieshql.model.dtos.EpisodesDTO;
import com.mercadolibre.movieshql.repositories.IEpisodesRepository;
import com.mercadolibre.movieshql.services.IEpisodesService;
import com.mercadolibre.movieshql.utils.MapperDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpisodesServiceImpl implements IEpisodesService {

    private final IEpisodesRepository episodesRepository;

    public EpisodesServiceImpl(IEpisodesRepository episodesRepository) {
        this.episodesRepository = episodesRepository;
    }

    @Override
    @Transactional
    public List<EpisodesDTO> findEpisodesOfAnySeriesByActor(String actorName, String actorLastName) {
        return episodesRepository.findEpisodesByActor(actorName, actorLastName).stream().map(MapperDTO::mapToEpisodeDTO).toList();
    }
}
