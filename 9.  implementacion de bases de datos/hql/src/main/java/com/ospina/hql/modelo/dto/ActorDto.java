package com.ospina.hql.modelo.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.ospina.hql.modelo.entidad.Actor}
 */
@Value
public class ActorDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String firstName;
    String lastName;
    BigDecimal rating;
    PeliculaDto favoriteMovie;
}