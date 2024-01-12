package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SerieRepository extends JpaRepository<Series, Integer> {

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("FROM Series s INNER JOIN Seasons ss ON s.id = ss.seriesBySerieId.id GROUP BY s.id HAVING COUNT(*) > :numberSeasons")
    List<Series> findAllByMinimumNumberOfSeasons(@Param("numberSeasons") Integer numberSeasons);
}
