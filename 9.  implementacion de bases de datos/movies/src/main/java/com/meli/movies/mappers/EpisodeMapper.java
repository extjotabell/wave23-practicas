package com.meli.movies.mappers;

import com.meli.movies.dtos.response.EpisodeDTO;
import com.meli.movies.model.Episode;

public class EpisodeMapper {

    private EpisodeMapper() {}
    public static EpisodeDTO toDTO(Episode episode) {
        return new EpisodeDTO(
                episode.getTitle(),
                episode.getNumber(),
                episode.getReleaseDate(),
                episode.getRating(),
                SeasonMapper.toDTO(episode.getSeason())
            );
    }
}
