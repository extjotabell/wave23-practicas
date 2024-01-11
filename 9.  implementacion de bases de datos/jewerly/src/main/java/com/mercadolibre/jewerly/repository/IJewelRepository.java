package com.mercadolibre.jewerly.repository;

import com.mercadolibre.jewerly.model.Jewel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {

}