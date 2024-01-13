package com.ejercicio.Movies.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int number;

    @JsonProperty("release_date")
    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    private double rating;

    @ManyToOne
    @JoinColumn(name = "season_id")
    @JsonProperty("season_id")
    private Season season;

    @ManyToMany(mappedBy = "episodes")
    private List<Actor> actors;
}
