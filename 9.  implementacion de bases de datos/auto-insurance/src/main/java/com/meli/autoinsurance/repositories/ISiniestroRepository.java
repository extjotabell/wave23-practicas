package com.meli.autoinsurance.repositories;

import com.meli.autoinsurance.entities.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}