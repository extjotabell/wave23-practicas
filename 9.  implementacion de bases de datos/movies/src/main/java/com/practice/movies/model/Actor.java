package com.practice.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favouriteMovie;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
