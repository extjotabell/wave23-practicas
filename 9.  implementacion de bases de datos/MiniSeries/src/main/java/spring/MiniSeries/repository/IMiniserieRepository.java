package spring.MiniSeries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.MiniSeries.model.MiniSerie;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie,Long> {
}
