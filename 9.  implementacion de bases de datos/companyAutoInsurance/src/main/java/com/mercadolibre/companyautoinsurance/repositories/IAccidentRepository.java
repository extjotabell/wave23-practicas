package com.mercadolibre.companyautoinsurance.repositories;

import com.mercadolibre.companyautoinsurance.models.entities.Accident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccidentRepository extends JpaRepository<Accident, Integer> {

}