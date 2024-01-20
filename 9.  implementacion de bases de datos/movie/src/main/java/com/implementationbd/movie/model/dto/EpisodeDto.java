package com.implementationbd.movie.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("number")
    private Integer number;

    @JsonProperty("release_date")
    private Date releaseDate;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("season")
    private SeasonDto season;
}
