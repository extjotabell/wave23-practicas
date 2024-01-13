package com.jpa.hql.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "users", schema = "movies_db")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic
    @Column(name = "remember_token", nullable = true, length = 100)
    private String rememberToken;
    @Basic
    @Column(name = "created_at", nullable = true)
    private LocalDateTime createdAt;
    @Basic
    @Column(name = "updated_at", nullable = true)
    private LocalDateTime updatedAt;
}
