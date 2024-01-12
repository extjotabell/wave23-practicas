package com.mercadolibre.composite.repository;

import com.mercadolibre.composite.entities.Buy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IBuyRepository extends JpaRepository<Buy, Long> {

}