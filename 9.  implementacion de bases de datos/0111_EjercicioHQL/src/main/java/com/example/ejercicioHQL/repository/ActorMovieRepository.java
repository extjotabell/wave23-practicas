package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, Integer> {
}
