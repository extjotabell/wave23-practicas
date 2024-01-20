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
public class MovieDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("rating")
    private Double rating;

    @JsonProperty("awards")
    private Integer awards;

    @JsonProperty("release_date")
    private Date releaseDate;

    @JsonProperty("length")
    private Integer length;

    @JsonProperty("genre")
    private GenreDto genre;
}
