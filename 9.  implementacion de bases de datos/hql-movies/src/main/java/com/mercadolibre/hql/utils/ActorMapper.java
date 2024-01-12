package com.mercadolibre.hql.utils;

import com.mercadolibre.hql.dto.ActorDTO;
import com.mercadolibre.hql.entity.Actors;

public class ActorMapper {
    public static ActorDTO actorMap(Actors actor) {
        return new ActorDTO(actor.getId(), actor.getCreatedAt(), actor.getUpdatedAt(), actor.getFirstName(), actor.getLastName(), actor.getRating());
    }
}
