package com.meli.movies.mappers;

import com.meli.movies.dtos.response.SeasonDTO;
import com.meli.movies.model.Season;

public class SeasonMapper {

    private SeasonMapper(){}

    public static SeasonDTO toDTO(Season season){
        return new SeasonDTO(
            season.getTitle(),
            season.getNumber(),
            season.getReleaseDate(),
            season.getEndDate(),
            SerieMapper.toDTO(season.getSerie())
        );
    }
}
