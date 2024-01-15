package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

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
