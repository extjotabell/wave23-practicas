package com.meli.movies.mappers;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.dtos.response.ActorFavoriteMovieDTO;
import com.meli.movies.dtos.response.MovieDTO;
import com.meli.movies.model.Actor;

public class ActorMapper {

    private ActorMapper(){}

    public static ActorDTO toDTO(Actor actor) {
        return new ActorDTO(
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating()
        );
    }

    public static ActorFavoriteMovieDTO toFavoriteMovieDTO(Actor actor) {
        MovieDTO movie = actor.getFavoriteMovie() != null ? MovieMapper.toDTO(actor.getFavoriteMovie()) : null;
        return new ActorFavoriteMovieDTO(
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating(),
                movie
        );
    }

}