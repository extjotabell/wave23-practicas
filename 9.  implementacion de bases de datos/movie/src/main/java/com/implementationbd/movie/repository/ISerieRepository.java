package com.implementationbd.movie.repository;

import com.implementationbd.movie.model.entity.Actor;
import com.implementationbd.movie.model.entity.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ISerieRepository extends CrudRepository<Actor, Long> {

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("SELECT s FROM Serie s WHERE size(s.seasons) > :seasonCount")
    List<Series> getSeriesWithMoreThanSeasons(int seasonCount);
}
