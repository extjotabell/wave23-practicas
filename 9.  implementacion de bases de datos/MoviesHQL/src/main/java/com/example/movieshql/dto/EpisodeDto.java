package com.example.movieshql.dto;

import com.example.movieshql.dto.SeasonDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link com.example.movieshql.model.Episode}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private Long number;
    private Instant releaseDate;
    private BigDecimal rating;
    private SeasonDto season;
}