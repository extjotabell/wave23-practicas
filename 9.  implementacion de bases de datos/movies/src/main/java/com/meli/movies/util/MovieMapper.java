package com.meli.movies.util;

import com.meli.movies.dto.MovieDTO;
import com.meli.movies.model.Movie;

public class MovieMapper {
    public static MovieDTO map(Movie movie) { return new MovieDTO(movie.getTitle()); }
}
