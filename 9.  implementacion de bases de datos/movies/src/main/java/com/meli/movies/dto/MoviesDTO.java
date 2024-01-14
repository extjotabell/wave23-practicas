package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MoviesDTO {
    private List<MovieDTO> movies;
}
