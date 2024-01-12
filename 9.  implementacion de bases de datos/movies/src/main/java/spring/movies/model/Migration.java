package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "migrations")
public class Migration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "migration", nullable = false, length = 255)
    private String migration;
    @Basic
    @Column(name = "batch", nullable = false)
    private Integer batch;

}
