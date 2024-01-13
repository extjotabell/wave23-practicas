package com.ejercicio.Movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class SeasonDTO {
    private Long id;
    private String title;
    private int number;
    @JsonProperty("release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("end_date")
    private LocalDateTime endDate;
    @JsonProperty("serie_id")
    private SerieDTO serie;
}
