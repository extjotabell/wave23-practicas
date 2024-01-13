package com.ejercicio.Movies.repository;

import com.ejercicio.Movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE SIZE(s.seasons) > :numberOfSeasons")
    List<Serie> findSeriesWithMoreThanNumberOfSeasons(@Param("numberOfSeasons") int numberOfSeasons);
}
