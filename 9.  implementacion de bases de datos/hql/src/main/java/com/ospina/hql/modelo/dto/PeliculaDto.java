package com.ospina.hql.modelo.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.ospina.hql.modelo.entidad.Pelicula}
 */
@Value
public class PeliculaDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    BigDecimal rating;
    Long awards;
    Instant releaseDate;
    Long length;
    Integer genreId;
}