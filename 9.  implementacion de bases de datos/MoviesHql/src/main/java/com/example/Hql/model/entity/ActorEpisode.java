package com.example.Hql.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "actor_episode", schema = "movies_db", catalog = "")
public class ActorEpisode {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;
}