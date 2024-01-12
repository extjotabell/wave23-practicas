package org.ejercicio.hql.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "episodes")
public class Episode {
    @Id
    private Long id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
    private Integer seasonId;
    @OneToMany(mappedBy = "episode")
    private List<ActorEpisode> actorEpisodes;
}
