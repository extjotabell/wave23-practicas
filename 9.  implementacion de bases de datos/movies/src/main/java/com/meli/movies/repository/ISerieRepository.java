package com.meli.movies.repository;

import com.meli.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Long> {
    @Query("FROM Serie s WHERE size(s.seasons) > :seasons")
    List<Serie> findBySeasonGreaterThan(@Param("seasons") Integer seasons);
}
