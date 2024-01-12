package com.ospina.hql.modelo.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * DTO for {@link com.ospina.hql.modelo.entidad.Season}
 */
@Value
public class SeasonDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Long number;
    Instant releaseDate;
    Instant endDate;
    Set<EpisodeDto> episodes;
}