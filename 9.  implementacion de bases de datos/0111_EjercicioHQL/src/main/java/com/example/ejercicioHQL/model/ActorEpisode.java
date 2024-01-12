package com.example.ejercicioHQL.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actor_episode")
@Getter
@Setter
public class ActorEpisode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id", nullable = false)
    Actor actor;

    @ManyToOne
    @JoinColumn(name = "episode_id", nullable = false)
    Episode episode;

}

