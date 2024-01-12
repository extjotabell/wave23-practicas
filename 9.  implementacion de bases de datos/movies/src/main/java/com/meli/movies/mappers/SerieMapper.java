package com.meli.movies.mappers;

import com.meli.movies.dtos.response.SerieDTO;
import com.meli.movies.model.Serie;

public class SerieMapper {

    private SerieMapper() {}

    public static SerieDTO toDTO(Serie serie) {
        return new SerieDTO(
                serie.getTitle(),
                serie.getReleaseDate(),
                serie.getEndDate(),
                serie.getGenre(),
                serie.getSeasons().size()
        );
    }
}
