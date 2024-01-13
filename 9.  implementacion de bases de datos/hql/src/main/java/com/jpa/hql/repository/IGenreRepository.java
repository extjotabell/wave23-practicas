package com.jpa.hql.repository;

import com.jpa.hql.model.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<GenreEntity, Integer> {
    GenreEntity findByNameEquals(String name);
}
