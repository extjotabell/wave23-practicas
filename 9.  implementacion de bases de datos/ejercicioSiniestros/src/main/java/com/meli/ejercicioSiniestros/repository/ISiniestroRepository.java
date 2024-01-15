package com.meli.ejercicioSiniestros.repository;

import com.meli.ejercicioSiniestros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Siniestro, Long> {
}
