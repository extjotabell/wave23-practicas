package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "actor_movie", schema = "movies_db", catalog = "")
public class ActorMovie {
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
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
