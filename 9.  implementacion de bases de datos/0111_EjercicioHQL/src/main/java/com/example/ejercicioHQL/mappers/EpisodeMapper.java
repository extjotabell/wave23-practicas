package com.example.ejercicioHQL.mappers;

import com.example.ejercicioHQL.dto.EpisodeDto;
import com.example.ejercicioHQL.model.Episode;

public class EpisodeMapper {

    public EpisodeMapper(){

    }

    public EpisodeDto mapToEpisodeDto(Episode episode){
        return new EpisodeDto(
                episode.getId(),
                episode.getTitle(),
                episode.getNumber(),
                episode.getReleaseDate(),
                episode.getRating()
        );
    }

}
