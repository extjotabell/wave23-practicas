package org.ejercicio.hql.utils;

import org.ejercicio.hql.model.dto.EpisodeDTO;
import org.ejercicio.hql.model.entity.Episode;

public class EpisodeMapper {
    public static EpisodeDTO episodeMap(Episode episode) {
        return new EpisodeDTO(episode.getId(), episode.getCreatedAt(), episode.getUpdatedAt(), episode.getTitle(), episode.getNumber(), episode.getReleaseDate(), episode.getRating(), episode.getSeasonId());
    }
}
