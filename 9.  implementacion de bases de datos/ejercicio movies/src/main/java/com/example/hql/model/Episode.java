package com.example.hql.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "episodes")
@Getter @Setter
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
    private Date releaseDate;
    private Double rating;
    @Column(name = "season_id")
    private Long seasonId;
    @ManyToMany
    @JoinTable(name = "actor_episode",
    joinColumns = @JoinColumn(name = "episode_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id"))
    @JsonIgnoreProperties("episodes")
    Set<Actor> actors;
}

