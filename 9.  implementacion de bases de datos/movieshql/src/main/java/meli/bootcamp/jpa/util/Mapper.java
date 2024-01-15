package meli.bootcamp.jpa.util;

import meli.bootcamp.jpa.model.Actor;
import meli.bootcamp.jpa.model.dto.ActorInfoDto;

public class Mapper {
  public static ActorInfoDto map(Actor actor) {
    return new ActorInfoDto(actor.getFirstName(), actor.getLastName(), actor.getRating());
  }
}
