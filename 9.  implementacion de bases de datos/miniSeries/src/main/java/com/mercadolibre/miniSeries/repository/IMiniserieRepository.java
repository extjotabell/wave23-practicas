package com.mercadolibre.miniSeries.repository;

import com.mercadolibre.miniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long>{
    
}
