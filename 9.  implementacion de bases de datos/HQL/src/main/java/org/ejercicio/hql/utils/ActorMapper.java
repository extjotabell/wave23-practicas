package org.ejercicio.hql.utils;

import org.ejercicio.hql.model.dto.ActorDTO;
import org.ejercicio.hql.model.entity.Actor;

public class ActorMapper {
    public static ActorDTO actorMap(Actor actor) {
        return new ActorDTO(actor.getId(), actor.getCreatedAt(), actor.getUpdatedAt(), actor.getFirstName(), actor.getLastName(), actor.getRating(), actor.getFavoriteMovieId());
    }
}
