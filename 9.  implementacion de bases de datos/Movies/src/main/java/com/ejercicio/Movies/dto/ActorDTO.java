package com.ejercicio.Movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ActorDTO {
    private Long id;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private Double rating;
    @JsonProperty("favorite_movie_id")
    private MovieDTO favoriteMovie;
    private List<MovieDTO> movies;
    private List<EpisodeDTO> episodes;
}
