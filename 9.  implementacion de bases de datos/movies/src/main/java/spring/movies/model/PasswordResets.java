package spring.movies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "password_resets", schema = "movies_db", catalog = "")
public class PasswordResets {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "token", nullable = false, length = 255)
    private String token;

    @Column(name = "created_at", nullable = true)
    private Timestamp createdAt;

}
