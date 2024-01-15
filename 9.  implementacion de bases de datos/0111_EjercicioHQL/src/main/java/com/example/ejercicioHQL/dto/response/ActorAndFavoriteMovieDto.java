package com.example.ejercicioHQL.dto.response;

import com.example.ejercicioHQL.dto.MovieDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorAndFavoriteMovieDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    private MovieDto favoriteMovie;
}
