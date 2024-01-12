package org.ejercicio.hql.utils;

import org.ejercicio.hql.model.dto.MovieDTO;
import org.ejercicio.hql.model.entity.Movie;

public class MovieMapper {
    public static MovieDTO MovieMap(Movie movie) {
        return new MovieDTO(movie.getId(), movie.getCreatedAt(), movie.getUpdatedAt(), movie.getTitle(), movie.getRating(), movie.getAwards(), movie.getReleaseDate(), movie.getLength(), movie.getGenreId());
    }
}
