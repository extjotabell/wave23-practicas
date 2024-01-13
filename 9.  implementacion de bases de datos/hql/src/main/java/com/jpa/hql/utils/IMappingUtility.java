package com.jpa.hql.utils;

import com.jpa.hql.model.dto.ActorDTO;
import com.jpa.hql.model.dto.EpisodeDTO;
import com.jpa.hql.model.dto.MovieDTO;
import com.jpa.hql.model.dto.SerieDTO;
import com.jpa.hql.model.entity.ActorEntity;
import com.jpa.hql.model.entity.EpisodeEntity;
import com.jpa.hql.model.entity.MovieEntity;
import com.jpa.hql.model.entity.SerieEntity;

public interface IMappingUtility {
    ActorDTO actorEntityToDTO(ActorEntity actorEntity);
    MovieDTO movieEntityToDTO(MovieEntity movieEntity);
    SerieDTO serieEntityToDTO(SerieEntity serieEntity);
    EpisodeDTO episodeEntityToDTO(EpisodeEntity episodeEntity);
}
