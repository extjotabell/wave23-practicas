package com.example.Movies.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    private String title;

    private Integer number;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;
}
