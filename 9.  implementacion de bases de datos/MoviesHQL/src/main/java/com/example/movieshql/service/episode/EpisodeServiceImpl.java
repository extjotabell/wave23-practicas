package com.example.movieshql.service.episode;

import com.example.movieshql.dto.EpisodeDto;
import com.example.movieshql.model.Episode;
import com.example.movieshql.repository.EpisodeRepository;
import com.example.movieshql.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {
    private final EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Override
    public List<EpisodeDto> findEpisodesByActor(Long actorId) {
        return episodeRepository.findEpisodesByActor(actorId).stream().map(DTOMapper::mapToEpisodeDTO).toList();
    }
}
