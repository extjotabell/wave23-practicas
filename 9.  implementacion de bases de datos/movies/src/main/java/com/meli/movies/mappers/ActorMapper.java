package com.meli.movies.mappers;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.model.Actor;

public class ActorMapper {

    private ActorMapper(){}

    public static ActorDTO toDTO(Actor actor) {
        return new ActorDTO(
                actor.getCreatedAt(),
                actor.getUpdatedAt(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating(),
                actor.getFavoriteMovie()
        );
    }

}