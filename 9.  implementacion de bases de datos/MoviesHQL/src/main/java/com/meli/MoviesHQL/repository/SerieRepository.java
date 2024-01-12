package com.meli.MoviesHQL.repository;

import com.meli.MoviesHQL.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends CrudRepository<Serie, Long> {

    @Query(
        "SELECT s FROM Serie s " +
        "JOIN Season se ON se.serie.id = s.id " +
        "GROUP BY s.id " +
        "HAVING COUNT(se) >= ?1"
    )
    List<Serie> findBySeasonsCountGreaterThanEqual(Integer seasons);

}