package com.example.ejercicioHQL.mappers;

import com.example.ejercicioHQL.dto.MovieDto;
import com.example.ejercicioHQL.model.Movie;

public class MovieMapper {

    public MovieMapper(){

    }

    public MovieDto mapMovieDto(Movie movie){
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getRating(),
                movie.getAwards(),
                movie.getReleaseDate(),
                movie.getLength()
        );
    }

}
