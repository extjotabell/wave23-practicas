package com.meli.movies.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GenreDTO {
    private String name;
    private Integer ranking;
    private Boolean active;
}
