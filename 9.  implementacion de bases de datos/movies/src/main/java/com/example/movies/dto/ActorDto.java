package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
    Long id;
    Date created_at;
    Date updated_at;
    String first_name;
    String last_name;
    double rating;
    Long favorite_movie_id;
}
