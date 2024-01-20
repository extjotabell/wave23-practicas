package com.implementationbd.movie.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeasonDto {
    @JsonProperty("number")
    private Integer number;

    @JsonProperty("release_date")
    private Date releaseDate;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("series")
    private SeriesDto series;

    @JsonProperty("season")
    private List<EpisodeDto> episodes;
}
