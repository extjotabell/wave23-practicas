package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.EpisodeDto;
import com.meli.MoviesHQL.exception.NotFoundException;
import com.meli.MoviesHQL.model.Actor;
import com.meli.MoviesHQL.model.Episode;
import com.meli.MoviesHQL.repository.ActorRepository;
import com.meli.MoviesHQL.repository.EpisodeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImp implements EpisodeService {

    EpisodeRepository episodeRepository;
    ActorRepository actorRepository;

    public EpisodeServiceImp(EpisodeRepository repository, ActorRepository actorRepository) {
        this.episodeRepository = repository;
        this.actorRepository = actorRepository;
    }

    @Override
    public List<EpisodeDto> findByActor(Long actorId) {
        // Check if actor exists
        actorRepository.findById(actorId).orElseThrow(() -> new NotFoundException("Actor not found"));

        List<Episode> episodes = episodeRepository.findByActor(actorId);
        return episodes.stream().map(EpisodeDto::new).toList();
    }
}
