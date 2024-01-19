package com.mercadolibre.demo.repositories;

import com.mercadolibre.demo.models.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel,Long> {
}
