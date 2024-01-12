package com.example.movies.repository;

import com.example.movies.dto.SerieNumberSeasonDTO;
import com.example.movies.models.Movie;
import com.example.movies.models.Serie;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
  @Query("select serie from Serie serie inner join serie.seasons season where season.number > :numberSeasons")
  Set<Serie> findAllWithGreaterNumberSeasons(@Param("numberSeasons") Integer numberSeasons);

}
