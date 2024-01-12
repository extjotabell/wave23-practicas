package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "actors")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "rating", precision = 1)
    private Double rating;

    @Column(name = "favorite_movie_id")
    private Long favoriteMovieId;

    @OneToMany(mappedBy = "actor")
    private List<ActorMovie> actorMovies;

    @OneToMany(mappedBy = "actor")
    private List<ActorEpisode> actorEpisodes;
}
