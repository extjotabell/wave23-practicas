package com.ejercicio.Movies.dto;

import com.ejercicio.Movies.model.Season;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class EpisodeDTO {
    private Long id;
    private String title;
    private int number;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    private double rating;
    @JsonProperty("season_id")
    private Season season;
}
