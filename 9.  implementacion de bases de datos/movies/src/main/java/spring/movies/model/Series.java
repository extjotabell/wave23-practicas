package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
public class Series {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "genre_id", nullable = true)
    private Long genreId;

}
