package com.example.movies.dto;

import java.math.BigDecimal;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorFavoriteMovieDTO {

  private Integer id;
  private String firstName;
  private String lastName;
  private BigDecimal rating;
  private MovieSimpleDTO favoriteMovie;
}
