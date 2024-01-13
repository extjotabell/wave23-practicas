package com.jpa.hql.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jpa.hql.model.dto.ActorDTO;
import com.jpa.hql.model.dto.EpisodeDTO;
import com.jpa.hql.model.dto.MovieDTO;
import com.jpa.hql.model.dto.SerieDTO;
import com.jpa.hql.model.entity.ActorEntity;
import com.jpa.hql.model.entity.EpisodeEntity;
import com.jpa.hql.model.entity.MovieEntity;
import com.jpa.hql.model.entity.SerieEntity;
import org.springframework.stereotype.Component;

@Component
public class MappingUtility implements IMappingUtility{

    private final ObjectMapper mapper = new ObjectMapper()
            .findAndRegisterModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    @Override
    public ActorDTO actorEntityToDTO(ActorEntity actorEntity) {
        return mapper.convertValue(actorEntity, ActorDTO.class);
    }

    @Override
    public MovieDTO movieEntityToDTO(MovieEntity movieEntity) {
        return mapper.convertValue(movieEntity, MovieDTO.class);
    }

    @Override
    public SerieDTO serieEntityToDTO(SerieEntity serieEntity) {
        return mapper.convertValue(serieEntity, SerieDTO.class);
    }

    @Override
    public EpisodeDTO episodeEntityToDTO(EpisodeEntity episodeEntity) {
        return mapper.convertValue(episodeEntity, EpisodeDTO.class);
    }
}
