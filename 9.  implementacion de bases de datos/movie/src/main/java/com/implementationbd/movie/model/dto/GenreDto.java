package com.implementationbd.movie.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto {
    @JsonProperty("name")
    private String name;

    @JsonProperty("ranking")
    private Integer ranking;

    @JsonProperty("active")
    private boolean active;
}
