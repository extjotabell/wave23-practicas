package com.example.Hql.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter @Setter
public class Movie {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "awards", nullable = false)
    private Integer awards;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "length", nullable = true)
    private Integer length;

    @Column(name = "genre_id", nullable = true)
    private Long genreId;

    @OneToMany(mappedBy = "movie")
    private List<ActorMovie> actorMovies;
}
