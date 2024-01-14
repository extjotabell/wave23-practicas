package com.meli.movies.util;

import com.meli.movies.dto.ActorDTO;
import com.meli.movies.model.Actor;

public class ActorMapper {
    public static ActorDTO map(Actor actor) {
        return new ActorDTO(actor.getFirstName(), actor.getLastName());
    }
}
