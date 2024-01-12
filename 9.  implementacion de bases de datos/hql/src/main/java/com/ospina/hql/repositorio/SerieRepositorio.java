package com.ospina.hql.repositorio;

import com.ospina.hql.modelo.entidad.Series;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepositorio extends CrudRepository<Series, Long> {

    @Query("SELECT s FROM Series s WHERE size(s.seasons) > :seasonCount")
    List<Series> encontrarSeriesConMasDeNTemporadas(@Param("seasonCount") int seasonCount);

}
