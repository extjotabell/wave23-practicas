package com.mercadolibre.hql.utils;

import com.mercadolibre.hql.dto.EpisodeDTO;
import com.mercadolibre.hql.entity.Episodes;

public class EpisodeMapper {
    public static EpisodeDTO episodeMap(Episodes episode) {
        return new EpisodeDTO(episode.getId(), episode.getCreatedAt(), episode.getUpdatedAt(), episode.getTitle(), episode.getNumber(), episode.getReleaseDate(), episode.getRating());
    }
}
