package com.ejercicio.Movies.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private int number;
    @JsonProperty("release_date")
    @Column(name = "release_date")
    private LocalDateTime releaseDate;
    @JsonProperty("end_date")
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "serie_id")
    @JsonProperty("serie_id")
    private Serie serie;

    @OneToMany
    @JoinColumn(name = "season_id")
    private List<Episode> episodes;
}
