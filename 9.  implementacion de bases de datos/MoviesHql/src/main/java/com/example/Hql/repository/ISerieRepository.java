package com.example.Hql.repository;

import com.example.Hql.model.dto.SerieDto;
import com.example.Hql.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    @Query("SELECT s FROM Series s WHERE s.id IN (SELECT distinct se.id FROM Season se WHERE se.number > :parametroCantidadTemporadas)")
    List<SerieDto> findByNumeroTemporadasGreaterThan(@Param("parametroCantidadTemporadas") int parametroCantidadTemporadas);
}
