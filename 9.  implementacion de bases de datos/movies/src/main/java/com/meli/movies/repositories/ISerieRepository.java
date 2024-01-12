package com.meli.movies.repositories;

import com.meli.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISerieRepository  extends JpaRepository<Serie, Long> {
    //Listar todas las series que tengan mas de <cantidad de temporadas recibida por parametro>
    @Query("SELECT U FROM Serie U JOIN U.seasons S GROUP BY U HAVING COUNT(S) > :seasons ORDER BY COUNT(S)")
    List<Serie> getSeriesBySeasons(Integer seasons);
}
