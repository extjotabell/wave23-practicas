package com.meli.movies.repository;

import com.meli.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllActorsWithFavoriteMovie();
}
