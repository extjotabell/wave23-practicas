package com.mercadolibre.movieshql.repositories;

import com.mercadolibre.movieshql.model.entities.Series;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISeriesRepository extends JpaRepository<Series, Long> {

    /**
     * List all series that have more than the quantity of seasons received as parameter.
     */
    @Query("SELECT series FROM Series series JOIN Seasons seasons ON seasons.series.id = series.id " +
            "GROUP BY series HAVING COUNT(seasons) > :seasons")
    List<Series> findSeriesBySeasons(Integer seasons);
}
