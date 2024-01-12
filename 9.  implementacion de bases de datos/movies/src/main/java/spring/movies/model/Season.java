package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "seasons")
public class Season {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at", nullable = true)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = true)
    private LocalDate updatedAt;

    @Column(name = "title", nullable = true, length = 500)
    private String title;

    @Column(name = "number", nullable = true)
    private Integer number;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "serie_id", nullable = true)
    private Long serieId;

}
