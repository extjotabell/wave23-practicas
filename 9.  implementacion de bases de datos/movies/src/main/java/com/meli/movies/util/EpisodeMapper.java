package com.meli.movies.util;

import com.meli.movies.dto.EpisodeDTO;
import com.meli.movies.model.Episode;

public class EpisodeMapper {
    public static EpisodeDTO map(Episode episode) {
        return new EpisodeDTO(episode.getTitle());
    }
}
