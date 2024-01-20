package com.implementationbd.movie.service.interfaces;

import com.implementationbd.movie.model.dto.EpisodeDto;

import java.util.List;

public interface IEpisodeService {
    List<EpisodeDto> getAllEpisodesWithActor(Long actorId);
}
