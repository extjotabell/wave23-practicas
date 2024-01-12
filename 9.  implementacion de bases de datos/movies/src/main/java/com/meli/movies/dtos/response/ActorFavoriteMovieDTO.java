package com.meli.movies.dtos.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActorFavoriteMovieDTO extends ActorDTO{
    private MovieDTO favoriteMovie;

    public ActorFavoriteMovieDTO(String firstName, String lastName, Double rating, MovieDTO favoriteMovie) {
        super(firstName, lastName, rating);
        this.favoriteMovie = favoriteMovie;
    }

}
