package meli.bootcamp.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import meli.bootcamp.jpa.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
  // public List<Actor> findWithFavouriteMovie();

  // public List<Actor> findByRatingGreaterThan(Double rating);

  // public List<Actor> findByWorkingMovie(String movie);
}
