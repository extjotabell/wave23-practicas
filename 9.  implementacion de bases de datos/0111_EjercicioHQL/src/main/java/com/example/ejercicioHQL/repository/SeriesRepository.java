package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

    @Query("SELECT s FROM Series s " +
            "JOIN s.seasonList sns " +
            "GROUP BY s " +
            "HAVING COUNT(sns) > :seasons " +
            "ORDER BY COUNT(sns)")
    List<Series> findBySeasonsNumber(Integer seasons);
}
