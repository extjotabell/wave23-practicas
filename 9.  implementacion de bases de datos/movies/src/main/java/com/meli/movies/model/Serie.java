package com.meli.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "series")
@Getter @Setter
public class Serie extends BaseEntity {
    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "serie_id")
    private Set<Season> seasons;
}
