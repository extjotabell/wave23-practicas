package com.jpa.hql.repository;

import com.jpa.hql.model.entity.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ISerieRepository extends JpaRepository<SerieEntity, Integer> {
    @Query(value = "SELECT series.* FROM series " +
            "INNER JOIN seasons ON series.id = seasons.serie_id " +
            "GROUP BY serie_id " +
            "HAVING COUNT(*) > :numberSeasons", nativeQuery = true)
    Set<SerieEntity> findByNumberOfSeasonsGreaterThan(Integer numberSeasons);
}
