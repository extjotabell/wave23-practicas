package com.example.movieshql.service.episode;

import com.example.movieshql.dto.EpisodeDto;
import com.example.movieshql.model.Episode;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeService {
    List<EpisodeDto> findEpisodesByActor(Long actorId);
}
