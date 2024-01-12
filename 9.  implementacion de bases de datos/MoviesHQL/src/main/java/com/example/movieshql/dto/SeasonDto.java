package com.example.movieshql.dto;

import com.example.movieshql.model.Season;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Season}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private Long number;
    private Instant releaseDate;
    private Instant endDate;
    private SeriesDto serie;
}