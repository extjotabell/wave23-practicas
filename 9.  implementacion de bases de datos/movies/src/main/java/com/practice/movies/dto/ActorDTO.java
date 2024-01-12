package com.practice.movies.dto;

import com.practice.movies.model.Movie;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private Integer id;
    private String first_name;
    private String last_name;
    private Double rating;
    private Integer favourite_movie_id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
