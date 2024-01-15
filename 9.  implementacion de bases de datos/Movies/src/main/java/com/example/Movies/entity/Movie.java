package com.example.Movies.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    private String title;

    private Double rating;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer length;
    
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
