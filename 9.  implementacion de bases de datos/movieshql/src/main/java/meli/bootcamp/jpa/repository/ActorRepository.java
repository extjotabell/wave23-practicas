package meli.bootcamp.jpa.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import meli.bootcamp.jpa.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
  public List<Actor> findByFavoriteMovieIdIsNotNull();

  public List<Actor> findByRatingGreaterThan(@Param("rating") BigDecimal rating);

  
  @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.title like %:title%")
  public List<Actor> findByWorkingMovieTitle(@Param("title") String title);
}
