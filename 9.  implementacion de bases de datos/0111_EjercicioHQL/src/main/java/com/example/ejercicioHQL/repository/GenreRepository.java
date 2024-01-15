package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
