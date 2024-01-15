package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Integer> {
}
