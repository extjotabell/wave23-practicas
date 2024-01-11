package com.mercadolibre.jeweler.repository;

import com.mercadolibre.jeweler.model.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelerRepository extends JpaRepository<Jewerly, Long> {
}
