package com.mercadolibre.hql.utils;

import com.mercadolibre.hql.dto.MovieDTO;
import com.mercadolibre.hql.entity.Movies;

public class MovieMapper {
    public static MovieDTO movieMap(Movies movie) {
        return new MovieDTO(movie.getId(), movie.getCreatedAt(), movie.getUpdatedAt(), movie.getTitle(), movie.getRating(), movie.getAwards(), movie.getReleaseDate(), movie.getLength());
    }
}
