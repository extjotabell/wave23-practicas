package com.mercadolibre.movieshql.repositories;

import com.mercadolibre.movieshql.model.entities.Genres;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenresRepository extends JpaRepository<Genres, Long> {
    Genres findByName(String name);
}
