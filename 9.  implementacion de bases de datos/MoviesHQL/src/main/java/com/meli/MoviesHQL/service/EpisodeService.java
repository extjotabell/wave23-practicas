package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.EpisodeDto;
import com.meli.MoviesHQL.model.Episode;

import java.util.List;

public interface EpisodeService {

    List<EpisodeDto> findByActor(Long actorId);

}
