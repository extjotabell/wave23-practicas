package com.meli.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter @Setter
public class Episode extends BaseEntity {

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "rating", precision = 3, scale = 1)
    private BigDecimal rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

    @ManyToMany(mappedBy = "actorEpisodes")
    private Set<Actor> actorEpisodes;
}
