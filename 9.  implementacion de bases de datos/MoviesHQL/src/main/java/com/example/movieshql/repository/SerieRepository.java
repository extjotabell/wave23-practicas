package com.example.movieshql.repository;

import com.example.movieshql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT s.serie FROM Season s JOIN s.serie WHERE s.number > :amount")
    List<Serie> findSeriesBySeasonAmountHigherThan(@Param("amount") int amount);
}
