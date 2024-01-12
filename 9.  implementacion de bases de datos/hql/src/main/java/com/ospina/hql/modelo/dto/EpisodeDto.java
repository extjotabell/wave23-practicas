package com.ospina.hql.modelo.dto;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.ospina.hql.modelo.entidad.Episode}
 */
@Value
public class EpisodeDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Long number;
    Instant releaseDate;
    BigDecimal rating;
}