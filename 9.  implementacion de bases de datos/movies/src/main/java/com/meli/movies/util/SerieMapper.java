package com.meli.movies.util;

import com.meli.movies.dto.SerieDTO;
import com.meli.movies.model.Serie;

public class SerieMapper {
    public static SerieDTO map(Serie serie) {
        return new SerieDTO(serie.getTitle());
    }
}
