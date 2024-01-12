package com.meli.movies.dtos.response;


import com.meli.movies.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MovieActorsDTO extends MovieDTO{
    private Set<ActorDTO> actors;

    public MovieActorsDTO(LocalDate createdAt, LocalDate updatedAt, String title, Double rating, Integer awards, LocalDate releaseDate, Integer length, GenreDTO genre, Set<ActorDTO> actors) {
        super(title, rating, awards, releaseDate, length, genre);
        this.actors = actors;
    }
}
