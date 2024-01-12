package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Actor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String firstName;
    String lastName;
    BigDecimal rating;
    MovieDto favoriteMovie;

    public ActorDto(Actor actor) {
        this.id = actor.getId();
        this.createdAt = actor.getCreatedAt();
        this.updatedAt = actor.getUpdatedAt();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
        this.rating = actor.getRating();

        if (actor.getFavoriteMovie() != null) this.favoriteMovie = new MovieDto(actor.getFavoriteMovie());
    }
}