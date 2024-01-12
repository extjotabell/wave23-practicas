package com.meli.movies.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private String firstName;
    private String lastName;
    private Double rating;
}
