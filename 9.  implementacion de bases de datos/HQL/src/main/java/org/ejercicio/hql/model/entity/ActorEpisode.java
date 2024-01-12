package org.ejercicio.hql.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;
    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;
}
