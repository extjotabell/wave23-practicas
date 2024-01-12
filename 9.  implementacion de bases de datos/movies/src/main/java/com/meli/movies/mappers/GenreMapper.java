package com.meli.movies.mappers;

import com.meli.movies.dtos.response.GenreDTO;
import com.meli.movies.model.Genre;

public class GenreMapper {

    private GenreMapper(){}

public static GenreDTO toDTO(Genre genre) {
        return new GenreDTO(
                genre.getName(),
                genre.getRanking(),
                genre.getActive()
        );
    }
}
