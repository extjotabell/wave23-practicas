package spring.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.movies.dto.SeriesDto;
import spring.movies.model.Series;

import java.util.List;

@Repository
public interface ISeriesRepository extends JpaRepository<Series,Long> {

    @Query("SELECT s FROM Series s WHERE s.id IN (SELECT distinct se.id FROM Season se WHERE se.number > :parametroCantidadTemporadas)")
    List<SeriesDto> findByNumeroTemporadasGreaterThan(@Param("parametroCantidadTemporadas") int parametroCantidadTemporadas);
}
