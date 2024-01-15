package com.example.hql.dto;

import com.example.hql.model.Episode;
import com.example.hql.model.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private Long id;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt, updatedAt;
    private String firstName, lastName, rating;

    private Long favoriteMovieId;
    Set<Movie> movies;
    Set<Episode> episodes;
}