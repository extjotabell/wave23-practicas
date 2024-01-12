package com.ospina.hql.modelo.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link com.ospina.hql.modelo.entidad.Series}
 */
@Value
public class SeriesDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Instant releaseDate;
    Instant endDate;
    Integer genreId;
    Set<SeasonDto> seasons;
}
