package com.example.ejercicioHQL.model;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @JoinColumn(name = "genre_id", nullable = false)
    Genre genre;

    @OneToMany(mappedBy = "favoriteMovie")
    Set<Actor> favoriteActorsMovie;

    @OneToMany(mappedBy = "movie")
    Set<ActorMovie> actors;

}

