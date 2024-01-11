package com.meli.movies.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_seq")
    @SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", initialValue = 101, allocationSize = 1)
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
    @OneToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}
