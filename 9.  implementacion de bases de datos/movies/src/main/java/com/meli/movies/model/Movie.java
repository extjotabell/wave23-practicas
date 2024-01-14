package com.meli.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter @Setter
public class Movie extends BaseEntity {

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer length;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "favoriteMovie")
    private Set<Actor> actorsFavoriteMovie;

    @ManyToMany(mappedBy = "movies")
    private Set<Actor> actors;
}
