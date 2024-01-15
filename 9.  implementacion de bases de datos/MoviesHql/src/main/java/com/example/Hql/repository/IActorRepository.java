package com.example.Hql.repository;

import com.example.Hql.model.dto.ActorDto;
import com.example.Hql.model.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IActorRepository extends JpaRepository<Actor,Long> {

    List<ActorDto> findByFavoriteMovieIdIsNotNull();

    List<ActorDto> findByRatingGreaterThan(@Param("parametroRating") Double parametroRating);

    @Query("SELECT a FROM Actor a JOIN a.actorMovies am JOIN am.movie m WHERE m.id = :parametroPelicula")
    List<ActorDto> findActorByMovie(@Param("parametroPelicula") Long parametroPelicula);
}
