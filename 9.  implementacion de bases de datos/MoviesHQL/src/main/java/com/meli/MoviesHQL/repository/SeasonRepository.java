package com.meli.MoviesHQL.repository;

import com.meli.MoviesHQL.model.Season;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends CrudRepository<Season, Long> {
}